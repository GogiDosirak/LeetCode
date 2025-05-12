class SeatManager {
    PriorityQueue<Integer> seat = new PriorityQueue<>();
    public SeatManager(int n) {
        for(int i = 1; i <= n; i++) {
            seat.add(i);
        }
    }
    
    public int reserve() {
        return seat.poll();
    }
    
    public void unreserve(int seatNumber) {
        seat.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */