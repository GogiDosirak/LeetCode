class Solution {
    public int minStartValue(int[] nums) {
        // prefix sum을 구하고, 거기서 가장 작은값을 구하자. 
        // 그럼 걔를 더해줬을 때 (거기까지 진행했을 때) 1이상 이어야 하니까,
        // (가장 작은값일 때 만족하는 숫자라면, 나머지는 더 큰 값이므로, 더해줘도 무조건 1이상임)
        // answer + min >= 1 
        // answer >= 1 - min
        // asnwer의 최소값은 1 - min이 된다.

        int answer = 0;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int min = prefix[0];
        for(int i = 1; i < nums.length; i++ ) {
            prefix[i] = prefix[i-1] + nums[i];
            min = Math.min(min, prefix[i]);
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