class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int window = s1.length();
        int lt = 0;

        for(char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(int rt = 0; rt < s2.length(); rt++) {
            char c = s2.charAt(rt);
            map2.put(c, map2.getOrDefault(c, 0) + 1);

            if(rt - lt + 1 > window) {
                char target = s2.charAt(lt);
                map2.put(target, map2.get(target) - 1);

                if(map2.get(target) == 0) {
                    map2.remove(target);
                }
                lt++;
            }

            if(map1.equals(map2)) return true;
        }
        return false; 
    }
}