import java.util.HashMap;

public class PartitionArrayIntoGroupQ2 {
    private static class Solution {
        public boolean partitionArray(int[] nums, int k) {
            if (nums.length % k != 0) return false;
            if (k == 1) return true;
            int numOfGroups = nums.length / k;
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.merge(num, 1, Integer::sum);
            }

            if (k > freq.size()) return false;

            for (int num : freq.keySet()) {
                if (freq.get(num) > numOfGroups) return false;
            }

            return true;
        }
    }
}
