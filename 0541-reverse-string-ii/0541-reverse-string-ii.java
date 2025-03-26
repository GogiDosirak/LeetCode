class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = s.length();

        // 경우의 수는 총 두가지
        // 1. 덩어리당 k만큼 뒤집기 (마지막 덩어리가 k <= x < 2k 더라도)
        // 2. 덩어리당 k만큼 뒤집다가 마지막 덩어리가 k보다 작은 경우에만 전체 뒤집기

        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            // k만큼 뒤집거나, k보다 작은 경우 전체 뒤집기 
            // 마지막 덩어리에 왔는데, 그게 k보다 작다면 2번 경우의 수로 뒤집어야함
            int right = Math.min(i + k - 1, n - 1); 

            while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;

        }
    }
     return new String(arr);
}
}