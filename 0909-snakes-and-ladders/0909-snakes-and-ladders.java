class Solution {
    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        int n = board.length;
        int[] route = new int[n * n +1];
        Arrays.fill(route, -1);
        queue.add(1);
        route[1] = 0;
        int level = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == n * n) {
                return route[curr];
            }
            // 주사위로 갈 수 있는 범위 탐색 
            for(int i = 1; i <= 6 && curr + i <= n * n; i++) {
                int next = curr + i;
                int row = (next - 1) / n;
                int col = (next - 1) % n;
                // 2차원 배열에서의 값 찾기 
                int special = row % 2 == 0 ? board[n - row - 1][col] : board[n - row - 1][n - col - 1];
                if (special > 0 && route[special] == -1) {
                    route[special] = route[curr] + 1; // 주사위를 굴린 횟수 
                    queue.add(special);
                } else {
                    if(route[next] == -1) {
                    route[next] = route[curr] + 1;  
                    queue.add(next);
                    }
                }
            }
        }
        return -1;
    }
}