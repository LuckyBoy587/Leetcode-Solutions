public class ApplyOperations2772 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkArray(new int[]{60, 72, 87, 89, 63, 52, 64, 62, 31, 37, 57, 83, 98, 94, 92, 77, 94, 91, 87, 100, 91, 91, 50, 26}, 4));
    }

    private static class Solution {
        public boolean checkArray(int[] nums, int k) {
            int n = nums.length;
            int[] sub = new int[n + k];
            int carry = 0;
            for (int i = 0; i < n; i++) {
                carry += sub[i];
                if (carry > nums[i]) return false;
                nums[i] -= carry;
                carry += nums[i];
                sub[i + k] = -nums[i];
                nums[i] = 0;
            }

            return carry + sub[n] == 0;
        }
    }
}
