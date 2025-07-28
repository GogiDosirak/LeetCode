class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for(int values : map.values()) {
            set.add(values);
        }

        if(set.size() > 1) return false;

        return true;
        
    }
}