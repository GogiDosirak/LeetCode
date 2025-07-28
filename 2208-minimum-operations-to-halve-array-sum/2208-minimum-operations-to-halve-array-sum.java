class Solution {
    public int halveArray(int[] nums) {
        int answer = 0;
        double sum = 0;
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(double n : nums) {
            sum += n;
            queue.add(n);
        }

        double goal = (double)sum/2;
        
        for(int i = 0; i < nums.length; i++) {
            double curr = queue.poll();
            sum -= curr/2;
            queue.add(curr/2);
            answer++;
            if(sum <= goal) {
                break;
            }
        }
        return answer;     
    }
}