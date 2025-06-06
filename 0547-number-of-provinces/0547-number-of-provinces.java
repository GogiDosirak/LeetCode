class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] ch = new boolean[isConnected.length];
        int answer = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if(ch[i] == false) {
                DFS(isConnected, ch, i);
                answer++;
            }
        }
        return answer;
    }

    public void DFS(int[][] isConnected, boolean[] ch, int n) {
        ch[n] = true;
        for(int i = 0; i < isConnected.length; i++) {
            if(ch[i] == false && isConnected[n][i] == 1) {
                DFS(isConnected, ch, i);
            }
        }
    }
}