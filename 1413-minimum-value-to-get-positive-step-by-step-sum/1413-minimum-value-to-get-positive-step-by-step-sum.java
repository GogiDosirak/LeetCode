class Solution {
    public int minStartValue(int[] nums) {
        int answer = 0;
        int min = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++ ) {
            sum += nums[i]; // 공간 복잡도 O(1)으로 누적합 구하기
            min = Math.min(min, sum);
        }

        // min값이 양수라면 무조건 1이 정답
        if(min > 0) {
            answer = 1;
            return answer;
        }

        answer = 1 - min ;
        return answer;
    }
}