class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        int lt = 0;

        for(int rt = 0; rt < cards.length; rt++) {
            map.put(cards[rt], map.getOrDefault(cards[rt], 0) + 1);
            if(map.get(cards[rt]) > 1) {
                answer = Math.min(answer, rt - lt + 1);
                lt++;
                map.put(cards[lt], map.get(cards[lt]) - 1);
            }
        }

        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
}