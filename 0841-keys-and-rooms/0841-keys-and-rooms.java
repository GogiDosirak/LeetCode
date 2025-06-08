class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] ch = new boolean[rooms.size()];

        DFS(rooms, ch, 0);

        for(boolean answer : ch) {
            if(answer == false) {
                return false;
            }
        }
        return true;
    }

    public void DFS(List<List<Integer>> rooms, boolean[] ch, int n) {
        ch[n] = true;
        for(int i = 0; i < rooms.get(n).size(); i++) {
            if(ch[rooms.get(n).get(i)] != true) {
                DFS(rooms, ch, rooms.get(n).get(i));
            }
        }
        return;
    }
}