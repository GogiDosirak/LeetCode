class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            answer[i] = -1;
        }

        if(2 * k + 1 > nums.length) { // 2 * k + 1, 즉 윈도우 사이즈가 배열의 길이보다 크다면, -1인 배열 반환
            return answer;
        } 
        if(k == 0) { // 0이라면 그냥 첫 배열 반환해주면 됨
            return nums;
        }


        long sum = 0; // 오버플로우 방지
        int windowSize = 2 * k + 1;
        for(int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }
        answer[k] = (int) (sum / windowSize); // 첫 평균 저장

        // 첫 윈도우 rt + 1부터 시작
        for(int i = windowSize; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i-windowSize];
            answer[i - k] = (int) (sum / windowSize);
        }

        return answer;
}
}