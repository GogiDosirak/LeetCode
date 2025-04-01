class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int answer[] = new int[nums.length];
        Arrays.fill(answer, -1); // 굳이 for문 돌 필요 X

        if(2 * k + 1 > nums.length) {
           return answer;
        }

        int lt = 0;
        long sum = 0;
        answer[k] = (int) (prefixSum[2 * k] / (2*k+1));

        for(int rt = 2 * k + 1; rt < nums.length; rt++) {
           sum = prefixSum[rt] - prefixSum[lt];
           lt++;
           answer[rt - k] = (int) (sum / (2*k+1));
        }

        return answer;
  }
}