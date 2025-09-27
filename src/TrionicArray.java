public class TrionicArray {
    public static void main(String[] args) {
        System.out.println(new Solution().isTrionic(new int[]{2, 1, 3}));
    }

    private static class Solution {
        public boolean isTrionic(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right && nums[left] < nums[left + 1]) left++;
            while (left < right && nums[right - 1] < nums[right]) right--;
            if (left == right || left == 0 || right == nums.length - 1) return false;

            while (left < right) {
                if (nums[left] > nums[left + 1]) left++;
                else return false;
            }

            return true;
        }
    }
}
