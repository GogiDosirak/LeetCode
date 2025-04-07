class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int answer = 0;
        int count = 0;
        int lt = 0;
        // 처음 k 길이 만큼의 subarray에서 모음 개수구하기
         for(int rt = 0; rt < k; rt++) {
            if(arr[rt] == 'a' || arr[rt] == 'e' || arr[rt] == 'i' || arr[rt] == 'o' || arr[rt] == 'u') {
                count++;
            }
        }

        answer = count;

        for(int rt = k; rt < s.length(); rt++) {
             if(arr[rt] == 'a' || arr[rt] == 'e' || arr[rt] == 'i' || arr[rt] == 'o' || arr[rt] == 'u') {
                count++;
            }
            if(arr[lt] == 'a' || arr[lt] == 'e' || arr[lt] == 'i' || arr[lt] == 'o' || arr[lt] == 'u') {
                count--;
                lt++;
            } else {
                lt++;
            }
            answer = Math.max(count, answer);
        }

        return answer;
        
    }
}