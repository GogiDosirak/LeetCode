class Solution {
    public char[] reverseString(char[] s) {
       int lt = 0;
       int rt = s.length - 1;

       while(lt < rt) {
        char temp = s[lt];
        s[lt] = s[rt];
        s[rt] = temp;
        lt++;
        rt--;
       }

       return s;
    }
}