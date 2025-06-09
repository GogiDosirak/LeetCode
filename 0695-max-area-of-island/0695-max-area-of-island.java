class Solution {
    int answer = 0;
    int width = 0;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) { 
                width = 0;
                DFS(grid, i, j);
                answer = Math.max(width, answer);
                }
            }
        }
        return answer;
    }

    public void DFS(int[][] grid, int x, int y) {
        width++;
        grid[x][y] = 0;
        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                DFS(grid, nx, ny);
            }
        }
        return;
    }
}