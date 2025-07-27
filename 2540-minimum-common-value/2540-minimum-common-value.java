class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
       int lt = 0;
       int rt = 0;
        int answer = 0;

       while(lt < nums1.length && rt < nums2.length) {
        if(nums1[lt] == nums2[rt]) {
            return nums1[lt];
        } else if(nums1[lt] < nums2[rt]) {
            lt++;
        } else {
            rt++;
        }
       }
       return -1;
    }
}