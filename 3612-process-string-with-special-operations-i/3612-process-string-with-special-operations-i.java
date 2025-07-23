class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {

            if(Character.isAlphabetic(c)) { 
                sb.append(c);
                } else if(c == '#') {
                    sb.append(sb.toString());
                } else if(c == '%') {
                    sb.reverse();
                } else {
                   if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                   }
                }
        }
        return sb.toString();
    }
}