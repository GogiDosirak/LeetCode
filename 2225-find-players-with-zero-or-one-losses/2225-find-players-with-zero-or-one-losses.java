class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lostMap = new HashMap<>();
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        for(int i = 0; i < matches.length; i++) {
            for(int j = 0; j < matches[0].length; j++) {
                lostMap.put(matches[i][j], 0);
            }
        } 

        for(int i = 0; i < matches.length; i++) {
           lostMap.put(matches[i][1], lostMap.getOrDefault(matches[i][1],0) + 1);
        }

        for(int i : lostMap.keySet()) {
            if(lostMap.getOrDefault(i,0) == 0) {
                answer.get(0).add(i);
            } else if(lostMap.get(i) == 1) {
                answer.get(1).add(i);
            }
        }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        return answer;
    }
}