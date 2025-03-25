class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int mergeIndex = m+n-1;
       int i = m-1;
       int j = n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[mergeIndex] = nums2[j];
                j--;
                mergeIndex--;
            } else {
                nums1[mergeIndex] = nums1[i];
                i--;
                mergeIndex--;
            }
        }
        // 비교할게 없어서 나왔다면, 남아있는건 다 작은 숫자이므로 차례대로 넣어주면 된다.
        while(i >= 0) {
            nums1[mergeIndex] = nums1[i];
            i--;
            mergeIndex--;
        }
           while(j >= 0) {
            nums1[mergeIndex] = nums2[j];
            j--;
            mergeIndex--;
        }




    }
}