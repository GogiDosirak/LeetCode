class Solution {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character,Integer> map = new HashMap<>();
        

        for(char c : sentence.toCharArray()) {
            map.put(c, 1);
        }

        if(map.size() == 26) {
            return true;
        }
        return false;
    }
}