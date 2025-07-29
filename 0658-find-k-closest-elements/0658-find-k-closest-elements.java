class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {
            if(Math.abs(b-x) == Math.abs(a-x)) {
                return a - b;
            }
            return Math.abs(a - x) - Math.abs(b - x);
            });

        for(int n : arr) {
            heap.add(n);
        }

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            answer.add(heap.poll());
        }

        Collections.sort(answer);


        return answer;
    }
}
