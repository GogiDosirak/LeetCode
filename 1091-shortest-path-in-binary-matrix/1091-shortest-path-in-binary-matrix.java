class Solution {
    int[] dx = {1,1,0,-1,-1,-1,0,1};
    int[] dy = {0,1,1,1,0,-1,-1,-1};
    int answer = 1;
    public int shortestPathBinaryMatrix(int[][] grid) {
        BFS(grid, new Node(0,0));
        return answer;
    }

    public void BFS(int[][] grid, Node start) {
        Queue<Node> queue = new LinkedList<>();
        if(grid[start.x][start.y] == 0) {
            queue.add(start);
            }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node now = queue.poll();
                if(now.x == grid.length - 1 && now.y == grid[0].length - 1) return;
                for(int j = 0; j < 8; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        queue.add(new Node(nx,ny));
                    }
                }
            }
            answer++;
        }

        answer = -1;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}