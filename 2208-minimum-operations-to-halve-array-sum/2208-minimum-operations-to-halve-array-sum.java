class Solution {
    public int halveArray(int[] nums) {
        int count = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double target = 0;

        for(double n : nums) {
            target += n;
            heap.add(n);
        }

        target /= 2;
        while(target > 0) {
            count++;
            double x = heap.poll();
            target -= (x/2);
            heap.add(x/2);
        }

        return count;
    }
}