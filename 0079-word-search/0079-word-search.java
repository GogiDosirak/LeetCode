class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
		        if(board[i][j] == word.charAt(0)) {
                     if(dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int idx) {
        if(board[x][y] != word.charAt(idx)) return false;
        if(idx == word.length() - 1) return true;

        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && visited[nx][ny] == false) {
                if(dfs(board, nx, ny, word, idx+1)) {
                    return true; // 재귀 말단의 반환값을 윗쪽까지 전달
                }
            }
        }
        visited[x][y] = false;
        return false;
    }
}