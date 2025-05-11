class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[k];

        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        for(int n : map.keySet()) {
            list.add(n);
        }

        list.sort((a,b) -> map.get(b) - map.get(a));

        for(int i = 0; i < k; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}