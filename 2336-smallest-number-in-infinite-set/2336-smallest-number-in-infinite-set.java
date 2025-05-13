class SmallestInfiniteSet {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    int n = 1;

    public SmallestInfiniteSet() {
        set.add(1);
        heap.add(1);
    }
    
    public int popSmallest() {
        int x = heap.poll();
        set.remove(x);
        heap.add(++n);
        set.add(n);

        return x;
    }
    
    public void addBack(int num) {
        if(!set.contains(num) && n > num) {
            heap.add(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */