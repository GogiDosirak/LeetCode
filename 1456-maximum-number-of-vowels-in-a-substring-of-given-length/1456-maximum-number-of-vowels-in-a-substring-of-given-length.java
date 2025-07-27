class Solution {
    public int maxVowels(String s, int k) {
        int lt = 0;
        int rt = k - 1;
        int answer = Integer.MIN_VALUE;

        int count = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                count++;
            }
        }
        answer = Math.max(answer, count);

        for(int i = rt + 1; i < s.length(); i++) {
            if(!isVowel(s.charAt(i))) {
                if(isVowel(s.charAt(lt))) {
                    count--; 
                } 
            } else {
                if(!isVowel(s.charAt(lt))) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
            lt++;
        }

        return answer;
    }

    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
