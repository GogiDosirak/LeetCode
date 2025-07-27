class Solution {
    public int[] getAverages(int[] nums, int k) {
     // sliding
    int lt = 0;
    int rt = 2*k;
    

    if(k == 0) return nums;

    int[] arr = new int[nums.length];
    Arrays.fill(arr, -1);

    if(nums.length < rt - lt + 1) return arr;


    long sum = 0;
    for(int i = 0; i <= rt; i++) {
        sum += nums[i];
    }
    arr[rt - k] = (int) (sum / (rt - lt + 1));

    for(int i = k + 1; i < nums.length - k; i++) {
        sum += nums[++rt];
        sum -= nums[lt];
        lt++;

        arr[i] = (int) (sum / (rt - lt + 1));
    }

    return arr;
     // prefix sum
  }
}