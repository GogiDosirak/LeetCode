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
        visited[room] = true;
        for(int n : rooms.get(room)) {
            if(visited[n] == false) {
                DFS(rooms, n);
            }
        }
    }
}