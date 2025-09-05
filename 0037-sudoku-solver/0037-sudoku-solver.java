class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(0, 0, board);
    }

    public boolean backtracking(int x, int y, char[][] board) {
        if(x == 9) return true;

        if(board[x][y] != '.') {
            if(y == 8) {
                if(backtracking(x + 1, 0, board)) return true;
            } else {
                if(backtracking(x, y + 1, board)) return true;
                }
        } else {
            for(int i = 1; i <= 9; i++) {
                if(check(x, y, (char) (i + '0'), board)) {
                    board[x][y] = (char) (i + '0');
                    if(y == 8) {
                        if(backtracking(x + 1, 0, board)) return true;
                    } else {
                        if(backtracking(x, y + 1, board)) return true;
                    }
                    board[x][y] = '.';
                } 
            }
        }
        return false;
    }

    public boolean check(int x, int y, char value, char[][] board) {
        // 가로열 확인
        for(int i = 0; i < 9; i++) {
            if(value == board[x][i]) {
                return false;
            }
        }
        // 세로열 확인
        for(int i = 0; i < 9; i++) {
            if(value == board[i][y]) {
                return false;
            }
        }
        // 정사각형 확인
        for(int i = (x/3)*3; i < (x/3)*3 + 3; i++) {
            for(int j = (y/3)*3; j < (y/3)*3 + 3; j++) {
                if(value == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}