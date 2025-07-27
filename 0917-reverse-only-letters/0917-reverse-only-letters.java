class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();

        int lt = 0;
        int rt = ch.length - 1;

        while(lt < rt) {
            if(Character.isAlphabetic(ch[lt]) && Character.isAlphabetic(ch[rt])) {
                char temp = ch[lt];
                ch[lt] = ch[rt];
                ch[rt] = temp;
                lt++;
                rt--;
            } else if(!Character.isAlphabetic(ch[lt])){
                lt++;
            } else {
                rt--;
            }
        }

        return new String(ch);
        
    }
}