class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int[][] arr = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        int lt = 0;
        int rt = nums.length - 1;

        while(lt <= rt) {
            int sum = arr[lt][0] + arr[rt][0];
            if(sum == target) {
                answer[0] = arr[lt][1];
                answer[1] = arr[rt][1];
                break;
            } else if(sum > target) {
                rt--;
            } else {
                lt++;
            }
        }
        return answer; 
    }
}