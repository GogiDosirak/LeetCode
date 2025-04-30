class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        for(int[] arr : grid) {
            StringBuilder sb = new StringBuilder();
            for(int x : arr) {
                sb.append(x);
                sb.append(',');
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < grid[i].length; j++) {
                sb.append(grid[j][i]);
                sb.append(',');
            } 
            String s = sb.toString();
            answer += map.getOrDefault(s, 0);
        }
        return answer;
    }
}