class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        int index = 0;

        for(int n : cards) {
            if(!map.containsKey(n)) {
                map.put(n, new ArrayList<>());
            }
            map.get(n).add(index);
            index++;
        }

        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for(int i = 1; i < list.size(); i++) {
                answer = Math.min(answer, list.get(i) - list.get(i-1) + 1);
            }
        }

        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
}