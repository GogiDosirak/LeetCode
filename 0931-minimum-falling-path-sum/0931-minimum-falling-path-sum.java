class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j + 1 < n && j - 1 >= 0) {
                  dp[i][j] = Math.min(dp[i-1][j+1],Math.min(dp[i-1][j-1], dp[i-1][j])) + matrix[i][j];
                } else if(j + 1 < n ) {
                    dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + matrix[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            answer = Math.min(answer, dp[n-1][i]); 
        }

        return answer;
    }
}