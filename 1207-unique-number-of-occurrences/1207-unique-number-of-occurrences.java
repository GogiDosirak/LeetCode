class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> count = new HashSet<>();

        for(int n : arr) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        for(int value : map.values()) {
            if(count.contains(value)) {
                return false;
            }
            count.add(value);
        }
        
        return true;
    }
}