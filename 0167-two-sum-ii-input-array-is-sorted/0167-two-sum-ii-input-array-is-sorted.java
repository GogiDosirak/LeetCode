
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        int lt = 0;
        int rt = numbers.length-1;

        while(lt < rt) {
            int sum = numbers[lt] + numbers[rt];
            if(sum == target) {
                break;
            }
            if(sum > target) {
                rt--;
            } else {
                lt++;
            }
        }
        answer[0] = lt+1;
        answer[1] = rt+1;

        return answer;

        
    }
}