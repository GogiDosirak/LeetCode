 class Solution {
 public int minimumCardPickup(int[] cards) {
 Map<Integer, List<Integer>> dic = new HashMap<>();
 for (int i = 0; i < cards.length; i++) {
 int num = cards[i];
 if (!dic.containsKey(num)) {
                dic.put(num, new ArrayList<>());
            }
            dic.get(num).add(i);
        }
 int ans = Integer.MAX_VALUE;
 for (int key: dic.keySet()) {
 List<Integer> arr = dic.get(key);
 for (int i = 0; i < arr.size() - 1; i++) {
                ans 
= Math.min(ans, arr.get(i + 1) - arr.get(i) + 1);
            }
        }
 if (ans == Integer.MAX_VALUE) {
 return -1;
        }
 return ans;
    }
 }
 