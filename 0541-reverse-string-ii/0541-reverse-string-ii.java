class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = s.length();

        // 경우의 수는 총 두가지
        // 1. 덩어리당 k만큼 뒤집기 (마지막 덩어리가 k <= x < 2k 더라도)
        // 2. 덩어리당 k만큼 뒤집다가 마지막 덩어리가 k보다 작은 경우에만 전체 뒤집기

        // 마지막 덩어리 전까지는 일관된 규칙으로 뒤집어도 됨
        int beforeLast = s.length()%(2*k) == 0 ? s.length() : s.length() - (2*k);

        for(int i = 0; i < beforeLast; i+= 2 * k) {
            int lt = i;
            int rt = i + k - 1;
            while(lt < rt) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--; 
            }
        }
        // 마지막 덩어리 처리
        // 조건 1 - 마지막 덩어리가 k <= x <2k인 경우 -> 똑같이 처리
        // 조건 2 - 마지막 덩어리가 k보다 작은 경우엔 전체 뒤집기
        int size = s.length() % (2 * k);
        if(s.length()%(2*k) != 0) { // 마지막 덩어리가 남은 경우에만
            if(size >= k && size < 2*k) {
            int lt = s.length() - size;
            int rt = lt + k - 1;
            while(lt < rt) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--; 
            }
            } else {
                int lt = s.length() - size;
                int rt = s.length()-1;
                     while(lt < rt) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--; 
            }
            }

        }

        return new String(arr);


    }
}
