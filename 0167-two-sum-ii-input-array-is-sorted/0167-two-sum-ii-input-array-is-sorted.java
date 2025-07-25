
class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int n = numbers.length;
      int[] answer = new int[2];

      int lt = 0;
      int rt = n - 1;

      while(true) {
        if(numbers[lt] + numbers[rt] == target) {
            answer[0] = lt + 1;
            answer[1] = rt + 1;
            break;
        } else if(numbers[lt] + numbers[rt] > target) {
            rt--;
        } else {
            lt++;
        }
      }

      return answer;
    }
}