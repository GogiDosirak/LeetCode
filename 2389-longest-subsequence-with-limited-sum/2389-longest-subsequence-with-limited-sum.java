class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] answer = new int[m];
        Arrays.sort(nums);

        for(int i = 0; i < m; i++) {
            int length = 0;
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += nums[j];
                if(sum > queries[i]) {
                    continue;
                } else {
                    length++;
                }
            }
            answer[i] = length;
        } 
        return answer;
    }
}