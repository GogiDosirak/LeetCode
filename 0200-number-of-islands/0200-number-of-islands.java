class Solution {
    int answer = 0;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        boolean[][] ch = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(ch[i][j] == false && grid[i][j] == '1') {
                    answer++;
                    DFS(grid, ch, i, j);
                }
            }
        }
        return answer;
    }

    public void DFS(char[][] grid, boolean[][] ch, int x, int y) {
        ch[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1' && ch[nx][ny] == false) {
                DFS(grid,ch,nx,ny);
            } 
        }
        return;
    }
}