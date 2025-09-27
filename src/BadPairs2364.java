import java.util.HashMap;

public class BadPairs2364 {
    private static class Solution {
        public long countBadPairs(int[] nums) {
            long res = 0;
            HashMap<Integer, Integer> diffMap = new HashMap<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int diff = nums[i] - i;
                int freq = diffMap.getOrDefault(diff, 0);
                res += freq;
                diffMap.put(diff, freq + 1);
            }
            long totalPairs = (long) n * (n - 1) / 2;
            return totalPairs - res;
        }
    }
}
