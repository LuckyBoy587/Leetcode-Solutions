import java.util.HashSet;
import java.util.List;

public class MinimumOperationsToCollect2869 {
    private static class Solution {
        public int minOperations(List<Integer> nums, int k) {
            int i = nums.size() - 1;
            HashSet<Integer> set = new HashSet<>();

            while (set.size() < k) {
                if (nums.get(i) <= k) {
                    set.add(nums.get(i));
                }
                i--;
            }
            return nums.size() - i - 1;
        }
    }
}
