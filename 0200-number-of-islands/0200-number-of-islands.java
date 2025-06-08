class Solution {
    int answer = 0;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    answer++;
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()) {
                        int[] cord = queue.poll();
                        for(int h = 0; h < 4; h++) {
                            int nx = cord[0] + dx[h];
                            int ny = cord[1] + dy[h];
                            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == '1') {
                                grid[nx][ny] = '0';
                                queue.offer(new int[]{nx,ny});
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}