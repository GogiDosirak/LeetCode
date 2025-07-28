class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int answer = -1;

        for(int i = 0; i < prefix.length; i++) {
            if(i == 0) {
                if(prefix[prefix.length-1] - prefix[i] == 0) {
                    answer = 0;
                    break;
                }
            } else if(i == prefix.length-1) {
                if(prefix[i-1] == 0) {
                    answer = prefix.length-1;
                    break;
                }
            } else {
            if(prefix[i-1] == prefix[prefix.length-1] - prefix[i]) {
                answer = i;
                break;
            }
            }
        }

        return answer;
    }
}