class Solution {
    public int largestAltitude(int[] gain) {
        int[] prefix = new int[gain.length + 1];
        prefix[0] = 0;
        prefix[1] = gain[0];
        int max = Math.max(prefix[0], prefix[1]);

        for(int i = 2; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + gain[i-1];
            max = Math.max(max, prefix[i]);
        }

        return max;
    }
}