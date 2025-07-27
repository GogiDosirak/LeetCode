class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        int lt = 0;
        int rt = 1;

        while (lt < nums.length) {
            if (nums[lt] == 0) {
                rt = Math.max(rt, lt + 1);
                while (rt < nums.length && nums[rt] == 0) {
                    rt++;
                }
                if (rt == nums.length) break;
                int temp = nums[lt];
                nums[lt] = nums[rt];
                nums[rt] = temp;
            }
            lt++;
        }
    }
}