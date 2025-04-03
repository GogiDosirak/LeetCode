class Solution {
    public String reverseWords(String s) {
       String[] arr = s.split(" ");
        StringBuilder answer = new StringBuilder();
        
       for(int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            if(i == arr.length -1) {
                answer.append(sb.reverse());
                break;
            }
            answer.append(sb.reverse()).append(" ");
            
            // .trim() 사용 시 문자열 양끝의 공백 제거 가능
       } 

        return answer.toString();
    }
}