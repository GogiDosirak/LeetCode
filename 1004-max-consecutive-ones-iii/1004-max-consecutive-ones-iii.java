class Solution {
    public int longestOnes(int[] nums, int k) {
        // k번만큼 뒤집은 0을 포함하는 슬라이딩 윈도우
        // 0을 만날때마다 count를 ++해주고, k를 넘으면, 왼쪽의 0부분을 하나 지우고 다시 오른쪽 최대범위 탐색
        int count = 0;
        int curr = 0;
        int answer = 0;
        int lt = 0;
        for(int rt = 0; rt < nums.length; rt++) { //rt를 nums[]의 끝까지 탐색
            if(nums[rt] == 0) {
                count++;
            }

            if(count > k) {
                if(nums[lt] == 0) {
                    curr--;
                    count--;
                }
                lt++;
            }
            curr = rt - lt + 1;
            answer = Math.max(answer, curr);
        }

        return answer;
    
    }
}