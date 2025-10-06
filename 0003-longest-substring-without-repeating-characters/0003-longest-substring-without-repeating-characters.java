class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 중복된 문자가 존재하지 않는 가장 긴 substring 구하기
        // 0 <= s.length <= 5 * 10^4   ->   O(N^2) 불가능
        // 영어, 숫자, 공백, 특수문자로 이루어짐

        // 투포인터 -> O(N)
        // 오른쪽으로 하나씩 늘려가다가, 2인 얘가 나오면 1이 될 때 까지 왼쪽으로 당김 
        
        Map<Character, Integer> map = new HashMap<>();
        int lt = 0;
        int answer = 0;
        for(int rt = 0; rt < s.length(); rt++) {
            char c = s.charAt(rt);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.get(c) >= 2) {
                char ltC = s.charAt(lt);
                map.put(ltC, map.get(ltC) - 1);
                if(map.get(ltC) == 0) {
                    map.remove(ltC);
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}