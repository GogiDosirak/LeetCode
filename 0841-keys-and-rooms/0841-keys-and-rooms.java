class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        BFS(rooms, 0);
        for(boolean b : visited) {
            if(b == false) return false;
        }

        return true;
    }

    public void BFS(List<List<Integer>> rooms, int room) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(room);
        visited[room] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int now = queue.poll();
                for(int n : rooms.get(now)) {
                    if(visited[n] == false) {
                        queue.add(n);
                        visited[n] = true;
                    }
                }
            }
        }
    }
}