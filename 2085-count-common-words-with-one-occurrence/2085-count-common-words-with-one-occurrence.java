class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for(String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        int answer = 0;
        for(String s : map1.keySet()) {
            if(map1.get(s) == 1) {
                if(map2.getOrDefault(s, 0) == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}