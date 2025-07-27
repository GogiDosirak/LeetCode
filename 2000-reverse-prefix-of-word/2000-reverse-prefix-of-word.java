class Solution {
    public String reversePrefix(String word, char ch) {
        char[] charArr = word.toCharArray();
        int lt = 0;
        int rt = 0;
       
       for(int i = 0; i < word.length(); i++) {
        if(word.charAt(i) == ch) {
            rt = i;
            break;
        }
       }

       while(lt < rt) {
        char temp = charArr[lt];
        charArr[lt] = charArr[rt];
        charArr[rt] = temp;
        lt++;
        rt--;
       }

       return new String(charArr);
    }
}