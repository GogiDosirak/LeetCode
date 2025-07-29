class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        for(int key : map.keySet()) {
            heap.add(key);
        }


        int[] answer = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = heap.poll();
        }

        return answer;
    }
}