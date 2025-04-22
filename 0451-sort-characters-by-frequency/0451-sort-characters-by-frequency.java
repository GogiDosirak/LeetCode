class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort((a,b) -> map.get(b) - map.get(a)); 

        for(char c : list) {
            for(int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
        
    }
}