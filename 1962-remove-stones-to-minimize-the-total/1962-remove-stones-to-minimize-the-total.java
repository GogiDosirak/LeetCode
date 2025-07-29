class Solution {
    public int minStoneSum(int[] piles, int k) {
       PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

       for(int n : piles) {
        heap.add(n);
       }

       for(int i = 0; i < k; i++) {
        double curr = heap.poll();
        heap.add((int) Math.ceil(curr / 2));
       }

        int answer = 0;
       for(int n : heap) {
        answer += n;
       }

       return answer;
    }
}