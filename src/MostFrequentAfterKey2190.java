import java.util.HashMap;

public class MostFrequentAfterKey2190 {
    private static class Solution {
        public int mostFrequent(int[] nums, int key) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(-1, 0);
            int maxKey = -1;

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == key) {
                    map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
                    if (map.get(nums[i + 1]) > map.get(maxKey)) {
                        maxKey = nums[i + 1];
                    }
                }
            }
            return maxKey;
        }
    }
}
