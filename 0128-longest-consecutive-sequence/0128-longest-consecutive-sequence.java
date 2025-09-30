class Solution {
    public int longestConsecutive(int[] nums) {
        // 정렬되지 않은 배열 nums
        // 배열 중 가장 긴 연속된 숫자의 길이 ex) 1,2,3,4
        // O(n) 시간복잡도로 해결 -> 정렬의 경우 O(nlogn)이므로 불가능
        
        // 해시셋에 넣고, 돌면서 다음 숫자가 있는지 체크 -> 있으면 또 다음 숫자가 있는지 체크 -> ... 길이 구하기
        // 중복된 경우 덮어씌워도 상관 X
        // 근데 이 경우 n번을 돌면서 길이만큼 또 반복하기 때문에.. 최악의 경우 n^2

        // 다른 방법은 없을까? - 배열을 돌 때 바로 있는지 체크, 걔는 다음에는 돌지않아야함 
        // 셋에서 삭제 -> O(1), for문 안에 while문이 있더라도 각 요소를 한 번씩만 방문하기 때문에 O(N)
        // HashMap, Set의 경우 keySet()으로 돌 경우 iterator 사용 -> remove로 컬렉션 구조가 바뀌면 ConcurrentModificationException 던짐
        // 이를 방지하기 위해, 수열의 시작점인 경우에만 길이 처리 -> contains로 O(1)으로 해결 가능


        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for(int n : nums) {
            map.put(n, 0);
        }

        for(int key : map.keySet()) {
            int length = 0;
            // 수열의 시작점이라면
            if(!map.containsKey(key - 1)) {
                while(map.containsKey(key)) {
                    length++;
                    key++;
                }
                answer = Math.max(answer, length);
            }
        }

        return answer;
    }
}