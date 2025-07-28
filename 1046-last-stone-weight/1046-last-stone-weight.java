class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);

        for(int n : stones) {
            queue.add(n);
        }

        while(queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if(x > y) {
                queue.add(x - y);
            } else if(x < y) {
                queue.add(y - x);
            }
        }
        if(queue.size() == 0) return 0;
        return queue.poll(); 
    }
}