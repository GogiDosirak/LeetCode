class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> map1 = new HashMap<>();
        String[] arr = s.split(" ");
        Map<String, Integer> map2 = new HashMap<>();

        if(pattern.length() != arr.length) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String t = arr[i];

           if(!map1.containsKey(c)) {
              map1.put(c, i);
           }

           if(!map2.containsKey(t)) {
              map2.put(t, i);
           }

           if(!map1.get(c).equals(map2.get(t))) return false;
        }

        return true;
    }
}