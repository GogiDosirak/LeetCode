class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lostMap = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>()); // 또는 List<List<Integer>> answer = Arrays.asList(new ArrayList<>(), new ArrayList<>()) - 이 경우 불변리스트이므로 크기를 변경하는 answer.add는 안되지만, 내부 요소를 변경하는 answer.get(0).add는 가능

        for(int[] arr : matches) {
            int winner = arr[0];
            int loser = arr[1];

            lostMap.put(winner, lostMap.getOrDefault(winner, 0)); // lostMap.putIfAbsent(winner, 0)도 사용 가능
            lostMap.put(loser, lostMap.getOrDefault(loser, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : lostMap.entrySet()) {
            int player = entry.getKey();
            int lose = entry.getValue();
            if(lose == 0) {
                answer.get(0).add(player);
            } else if(lose == 1) {
                answer.get(1).add(player);
            }
        }

        Collections.sort(answer.get(0));    // 내부적으로 O(NlogN) 정렬, 정렬이 문제에 등장하면 O(NlogN)을 깔고 들어간다고 보면됨.
        Collections.sort(answer.get(1));

        return answer;
    }
}