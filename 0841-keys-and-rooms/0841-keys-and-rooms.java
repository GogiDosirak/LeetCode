class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] ch = new boolean[rooms.size()];
        for(int i = 0; i < rooms.size(); i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < rooms.size(); i++) {
            for(int j = 0; j < rooms.get(i).size(); j++) {
                graph.get(i).add(rooms.get(i).get(j));
            }
        }

        DFS(graph, ch, 0);

        for(boolean answer : ch) {
            if(answer == false) {
                return false;
            }
        }
        return true;
    }

    public void DFS(List<List<Integer>> graph, boolean[] ch, int n) {
        ch[n] = true;
        for(int i = 0; i < graph.size(); i++) {
            if(ch[i] != true && graph.get(n).contains(i)) {
                DFS(graph, ch, i);
            }
        }
        return;
    }
}