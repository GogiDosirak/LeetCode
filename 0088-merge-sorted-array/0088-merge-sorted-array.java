class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 거꾸로부터 채우는게 편하다 - 왜? 뒤엔 0으로 채워져있고, 앞에서부터 채우면 따로 상태를 유지해야함
        int mergeIndex = m+n-1;
        int lt = m-1;
        int rt = n-1;

        while(lt >= 0 && rt >= 0) {
            if(nums1[lt] >= nums2[rt]) {
                nums1[mergeIndex] = nums1[lt];
                lt--;
                mergeIndex--;
            } else {
                nums1[mergeIndex] = nums2[rt];
                rt--;
                mergeIndex--;
            }
        }

        while(lt >= 0) {
            nums1[mergeIndex] = nums1[lt];
            lt--;
            mergeIndex--;
        }

        while(rt >= 0) {
            nums1[mergeIndex] = nums2[rt];
            rt--;
            mergeIndex--;
        }
    }
}