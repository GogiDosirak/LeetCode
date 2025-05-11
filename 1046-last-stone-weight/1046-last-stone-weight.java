class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);

        for(int n : stones) {
            heap.add(n);
        }

        while(heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();

            int newStone = y - x;

            if(newStone > 0) {
                heap.add(newStone);
            }
        }

        if(heap.size() == 0) {
            return 0;
        }

        return heap.poll();
    }
}