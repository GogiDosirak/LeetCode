class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int answer = 0;

        for(int n : piles) {
            heap.add(n);
        }

        for(int i = 0; i < k; i++) {
            int x = heap.poll();
            heap.add(x - (x/2));
        }

        for(int n : heap) {
            answer += n;
        }

        return answer;
    }
}