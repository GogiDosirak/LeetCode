class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] ch = new boolean[isConnected.length];
        int answer = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(ch[i] != true) {
                answer++;
                DFS(isConnected, ch, i);
            }
        }
        return answer;
    }

    public void DFS(int[][] isConnected, boolean[] ch, int n) {
        ch[n] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(ch[i] != true && isConnected[n][i] == 1) {
                DFS(isConnected, ch, i);
            }
        }
    }
}