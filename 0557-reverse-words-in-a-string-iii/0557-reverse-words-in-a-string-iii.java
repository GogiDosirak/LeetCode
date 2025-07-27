class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" "); 
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        
        for(int i = 0; i < arr.length; i++) {
            String t = arr[i];
            for(int j = 0; j < t.length(); j++) {
                sb.append(t.charAt(j));
            }
            answer.append(sb.reverse());
            if(i != arr.length - 1) {
                answer.append(' ');
            }
            sb = new StringBuilder();
        }
        

        return answer.toString();
       
    }
}