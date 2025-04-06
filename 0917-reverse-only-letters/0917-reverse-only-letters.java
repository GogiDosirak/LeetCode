class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int lt = 0;
        int rt = s.length()-1;

        while(lt < rt) {
            if(!Character.isAlphabetic(arr[lt])) {
                lt++;
                continue;
            } 
            if(!Character.isAlphabetic(arr[rt])) {
                rt--;
                continue;
            }
            // 아닌 경우에만 swap 진행
            char tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;
            lt++;
            rt--;
        }
        return new String(arr);
    }
}