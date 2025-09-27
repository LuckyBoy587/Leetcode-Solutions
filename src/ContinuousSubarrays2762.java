import java.util.TreeMap;

public class ContinuousSubarrays2762 {
    public static void main(String[] args) {
        System.out.println(new Solution().continuousSubarrays(new int[]{1,2,3}));
    }

    private static class Solution {
        public long continuousSubarrays(int[] nums) {
            int i = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            long res = 0;
            for (int j = 0;j < nums.length; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                while (map.lastKey() - map.firstKey() > 2) {
                    if (map.get(nums[i]) == 1) map.remove(nums[i]);
                    else map.put(nums[i], map.get(nums[i]) - 1);
                    ++i;
                }

                res += j - i + 1;
            }
            return res;
        }
    }
}
