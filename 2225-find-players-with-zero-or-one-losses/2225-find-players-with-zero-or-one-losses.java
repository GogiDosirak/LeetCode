class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lostMap = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for(int[] arr : matches) {
            int winner = arr[0];
            int loser = arr[1];

            lostMap.put(winner, lostMap.getOrDefault(winner, 0)); // lostMap.putIfAbsent(winner, 0)도 사용 가능
            lostMap.put(loser, lostMap.getOrDefault(loser, 0) + 1);
        }

        for(int key : lostMap.keySet()) {
            if(lostMap.get(key) == 0) {
                answer.get(0).add(key);
            } else if(lostMap.get(key) == 1) {
                answer.get(1).add(key);
            }
        }

        Collections.sort(answer.get(0));    // 내부적으로 O(NlogN) 정렬, 정렬이 문제에 등장하면 O(NlogN)을 깔고 들어간다고 보면됨.
        Collections.sort(answer.get(1));

        return answer;
    }
}