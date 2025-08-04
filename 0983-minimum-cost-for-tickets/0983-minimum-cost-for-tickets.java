class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1] + 1];
        boolean[] travel = new boolean[days[days.length-1] + 1];

        for(int i = 0; i < days.length; i++) {
            travel[days[i]] = true;
        }


        // 여행을 가는 날이 아니면 티켓이 필요가 없다
        // -> 전 날 비용을 그대로 사용    
        for(int i = 1; i <= days[days.length-1]; i++) {
            if(travel[i] == false) {
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = costs[0] + dp[i-1]; // 과거 1일권 티켓을 산 경우
            dp[i] = Math.min(dp[i], costs[1] + dp[Math.max(i - 7, 0)]); // 과거 7일권 티켓을 산 경우
            dp[i] = Math.min(dp[i], costs[2] + dp[Math.max(i - 30, 0)]); // 과거 30일권 티켓을 산 경우
        }

        return dp[days[days.length-1]];
        
    }
}