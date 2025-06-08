class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        boolean[] ch = new boolean[n];

        for (List<Integer> edge : edges) {
            ch[edge.get(1)] = true;
        }

        for(int i = 0; i < ch.length; i++) {
            if(ch[i] != true) {
                answer.add(i);
            }
        }

        return answer;
    }
}