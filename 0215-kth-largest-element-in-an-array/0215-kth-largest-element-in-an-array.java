class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : nums) {
            heap.add(n);
        }

        int answer = 0;

        for(int i = 0; i < k; i++) {
            answer = heap.poll();
        }

        return answer;
    }
}