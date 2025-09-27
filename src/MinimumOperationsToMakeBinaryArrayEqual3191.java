public class MinimumOperationsToMakeBinaryArrayEqual3191 {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{0, 1, 1, 0, 1, 0, 0}));
        System.out.println(new Solution().minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(new Solution().minOperations(new int[]{0, 1, 1, 1}));
    }

    private static class Solution {
        public int minOperations(int[] nums) {
            int[] flipCounts = new int[nums.length + 4];
            int result = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                flipCounts[i] ^= flipCounts[i - 1];
                if ((nums[i - 1] ^ flipCounts[i]) == 0) {
                    flipCounts[i] ^= 1;
                    flipCounts[i + 3] ^= 1;
                    result++;
                }
            }

            if ((flipCounts[flipCounts.length - 1]) == 0 && (flipCounts[flipCounts.length - 2]) == 0 && (flipCounts[flipCounts.length - 3]) == 0) {
                return result;
            }

            return -1;
        }
    }
}
