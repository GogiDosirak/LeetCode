class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        // 여기서 가장 작은 숫자만큼 ballon을 만들 수 있다.
        int min = Integer.MAX_VALUE;
        min = Math.min(b, a);
        min = Math.min(min, l);
        min = Math.min(min, o);
        min = Math.min(min, n);

        return min;
    }
}