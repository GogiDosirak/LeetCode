class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int lt, int rt, int target) {
        int mid = (lt + rt) / 2;
        if(rt < lt) return -1;
        if(nums[mid] < target) {
            return binarySearch(nums, mid + 1, rt, target);
        } else if(nums[mid] > target) {
            return binarySearch(nums, lt, mid - 1, target);
        } else {
            return mid;
        }
    }
}
