class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int window = s1.length();

        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if(i >= window) {
                char target = s2.charAt(i - window);
                map2.put(target, map2.get(target) - 1);

                if(map2.get(target) == 0) {
                    map2.remove(target);
                }

                if(map1.equals(map2)) {
                    return true;
                }
            }
        }
          return false;
    }
}