class Solution {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        backtracking(s, 0, list);
        return answer;
    }

    public void backtracking(String s, int start, List<String> list) {
         if(start == s.length()) {
            answer.add(new ArrayList<>(list));
            return;
         }

         for(int i = start; i < s.length(); i++) {
            String now = s.substring(start, i + 1);
            if(isPalindrome(now)) {
                list.add(now);
                backtracking(s, i + 1, list);
                list.remove(list.size() - 1);
            }
         }

    }

    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}