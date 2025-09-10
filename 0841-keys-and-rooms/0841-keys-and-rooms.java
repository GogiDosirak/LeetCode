class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        DFS(rooms, 0);
        for(boolean b : visited) {
            if(b == false) return false;
        }

        return true;
    }

    public void DFS(List<List<Integer>> rooms, int room) {
        List<Integer> list = rooms.get(room);
        visited[room] = true;
        for(int i = 0; i < list.size(); i++) {
            if(visited[list.get(i)] == false) {
                DFS(rooms, list.get(i));
            }
        }
    }
}