class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    public int binarySearch(int[] nums, int target) {
        int lt = 0;
        int rt = nums.length - 1;
        int mid = (lt + rt) / 2;

        while(lt <= rt) {
            if(nums[mid] < target) {
                lt = mid + 1;
            } else if(nums[mid] > target) {
                rt = mid - 1;
            } else if(nums[mid] == target) {
                return mid;
            }
            mid = (lt + rt) / 2;
        }

        return -1;
    }
}