class Solution {
    public boolean isCircularSentence(String sentence) {
        
        // 조건 1 - 각 단어의 마지막 문자 = 다음 단어의 첫 문자
        // 조건 2 - 첫 단어의 첫 문자 = 마지막 단어의 마지막 문자 

        // 단어가 하나인 경우엔 조건 2만 만족해도됨
        String[] arr = sentence.split(" ");

        if(arr.length == 1) {
            if(arr[0].charAt(0) == arr[0].charAt(arr[0].length()-1)) {
                return true;
            } else {
                return false;
            }
        } else {
            // 단어가 두개 이상인 경우엔 조건 1,2 둘 다 만족
            for(int i = 0; i < arr.length - 1; i++) {
                String s = arr[i];
                if(s.charAt(s.length()-1) != arr[i+1].charAt(0)) {
                    return false; 
                } 
            } 
            // 마지막인 경우에는 첫 단어의 첫 문자 = 마지막 단어의 마지막 문자만 만족하면 됨
            if(arr[0].charAt(0) != arr[arr.length-1].charAt(arr[arr.length-1].length() - 1)) {
                return false;
            }
        }

        return true;
    }
}