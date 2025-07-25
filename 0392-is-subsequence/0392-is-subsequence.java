class Solution {
    public boolean isSubsequence(String s, String t) {
        int lt = 0;
        int rt = 0;

        while(lt < s.length() && rt < t.length()) {
            if(s.charAt(lt) == t.charAt(rt)) {
                lt++;
                rt++;
            } else {
                rt++;
            }
        }

        if(lt >= s.length()) return true;

        return false;       
    }
}