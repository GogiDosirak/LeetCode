class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0;
        int answer = 0;
        int lt = 0;
        for(int rt = 0; rt < s.length(); rt++) {
            char a = s.charAt(rt);
            char b = t.charAt(rt);
            cost += Math.abs(a - b);

            if(cost <= maxCost) {
                answer = Math.max(answer, rt - lt + 1);
                continue;
            } 
            while(cost > maxCost) {
                cost -= Math.abs(s.charAt(lt) - t.charAt(lt));
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
        
    }
}