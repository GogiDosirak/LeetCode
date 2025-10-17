class Solution {
    public int uniquePaths(int m, int n) {
        // 왼쪽위 끝에서 오른쪽아래 끝까지 이동
        // 아래 또는 오른쪽으로만 갈 수 있음 
        // 가능한 모든 유일한 경로의 경우의 수 구하기
        // 완탐의 경우 100 * 100이면 2^200 이므로 불가능할듯? -> DFS, BFS 불가능
        // 1,1로 갈 수 있는 경우의 수는 1,0 또는 0,1까지 갈 수 있는 경우의 수를 합한 값 -> dp
        // 0,x 라인은 왼쪽으로부터만 접근 가능
        // x,0 라인은 위에서부터만 접근 가능

        int[][] dp = new int[m][n];

        // 0,x 라인 세팅
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // x,0 라인 세팅
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // dp 시작
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];      
    }
}
