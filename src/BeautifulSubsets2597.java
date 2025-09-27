import java.util.HashSet;

public class BeautifulSubsets2597 {
    private static class Solution {
        public int beautifulSubsets(int[] nums, int k) {
            return get(nums, 0, k, new HashSet<>());
        }

        private int get(int[] nums, int index, int k, HashSet<Integer> visited) {
            if (index == nums.length) return visited.isEmpty() ? 0 : 1;
            int res = get(nums, index + 1, k, visited);
            if (!visited.contains(Math.abs(nums[index] - k)) && !visited.contains(Math.abs(nums[index] + k))) {
                visited.add(nums[index]);
                res += get(nums, index + 1, k, visited);
                visited.remove(nums[index]);
            }
            return res;
        }
    }
}
