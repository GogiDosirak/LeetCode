class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int lt = 0;
        int rt = word.indexOf(ch);
        if(rt == -1) { // target word가 없다면 (indexOf의 반환값이 -1이라면)
            return word;
        }

        while(lt < rt) {
            char tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;
            lt++;
            rt--;
        }
        return new String(arr);
    }
}