class Solution {
    int[] dx = {1,1,0,-1,-1,-1,0,1};
    int[] dy = {0,1,1,1,0,-1,-1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) {
            return -1;
        }

        if(grid.length == 1) {
            return 1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        grid[0][0] = 1;
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                for(int j = 0; j < 8; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 0) {
                        if(nx == grid.length - 1 && ny == grid[0].length -1) {
                            return level + 1;
                        }
                        queue.add(new Node(nx,ny));
                        grid[nx][ny] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
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