class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {
            int prior = points[a][0] * points[a][0] + points[a][1] * points[a][1];
            int later = points[b][0] * points[b][0] + points[b][1] * points[b][1];
            return prior - later;
            });

        int[][] kClosest = new int[k][2];

        for(int i = 0; i < points.length; i++) {
            heap.add(i);
        }

        for(int i = 0; i < k; i++) {
            int index = heap.poll();
            kClosest[i] = points[index];
        }

        return kClosest;
    }
}