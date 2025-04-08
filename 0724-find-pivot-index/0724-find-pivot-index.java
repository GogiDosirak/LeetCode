class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        suffixSum[nums.length-1] = nums[nums.length-1];

        // prefixSum 먼저 구하기
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        // suffixSum 구하기
        for(int i = nums.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + nums[i];
        }

        // 중요한건 어떻게든 O(N)으로 푸는 것
        // i를 기준으로, leftSum과 rightSum이 같다면 그것이 pivot index인것
        // i를 이동시켜가면서 왼쪽과 오른쪽의 합을 비교
         for (int i = 0; i < nums.length; i++) {
            int leftSum = i == 0 ? 0 : prefixSum[i - 1]; // 맨 왼쪽인 경우 0, 아니라면 i의 한칸 왼쪽
            int rightSum = i == nums.length - 1 ? 0 : suffixSum[i + 1]; // 맨 오른쪽인 경우 0, 아니라면 i의 한칸 오른쪽
            
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}