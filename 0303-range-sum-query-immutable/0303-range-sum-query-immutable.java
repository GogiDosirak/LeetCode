class NumArray {
    int[] nums;
    int[] prefixSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        // 클래스 초기화 시점에 prefixSum 배열도 구해놓기. 안그러면 sumRange할때마다 새로구함
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) {
            return prefixSum[right]; 
        } else {
             return prefixSum[right] - prefixSum[left-1]; // left가 0이 아니라면 right에서 left-1까지의 합을 빼줌
        }
    }
}
