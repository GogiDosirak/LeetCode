class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefixSum = new int[gain.length]; 
        prefixSum[0] = gain[0];
        int answer = Math.max(0, prefixSum[0]); // 0을 자연스레 포함시킴
        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + gain[i]; 
            answer = Math.max(answer, prefixSum[i]);
        }

        return answer;
    }
}