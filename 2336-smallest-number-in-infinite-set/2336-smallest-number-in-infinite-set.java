class SmallestInfiniteSet {
    PriorityQueue<Integer> heap;
    Set<Integer> set;
    int n;

    public SmallestInfiniteSet() {
        n = 1;
        heap = new PriorityQueue<>();
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        if(!heap.isEmpty()) {
            int x = heap.poll();
            set.remove(x);
            return x;
        }
        return n++;
    }
    
    public void addBack(int num) {
        if(n > num && set.add(num)) {
            heap.add(num);
        }
    }
}