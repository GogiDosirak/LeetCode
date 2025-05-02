class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < cards.length; i++) {
            if(map.containsKey(cards[i])) {
                answer = Math.min(answer, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }

        if(answer == Integer.MAX_VALUE) return -1;
        return answer;

    }
}