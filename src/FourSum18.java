import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }

    private static class Solution {
        final int k = 4;
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            search(nums, target, 0, new ArrayList<>());
            return res;
        }

        private void search(int[] nums, long target, int start, List<Integer> path) {
            if (start == nums.length) return;
            if (k - path.size() == 2) {
                twoSum(nums, target, start, path);
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                path.add(nums[i]);
                search(nums, target - nums[i], i + 1, path);
                path.removeLast();
            }
        }

        private void twoSum(int[] nums, long target, int start, List<Integer> path) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(new ArrayList<>(path));
                    path.removeLast();
                    path.removeLast();
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
