class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int temp = i;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        int answer = 0;

        for(int key : map.keySet()) {
            answer = Math.max(map.get(key), answer);
        }

        return answer;
    }
}