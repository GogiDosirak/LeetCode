class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lt = 0;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        

        for(int rt = 0; rt < s.length(); rt++) {
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);
            while(map.get(s.charAt(rt)) > 1) {
                map.put(s.charAt(lt), map.get(s.charAt(lt)) - 1);
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
        
    }
}