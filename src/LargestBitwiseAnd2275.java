public class LargestBitwiseAnd2275 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
    }

    private static class Solution {
        public int largestCombination(int[] candidates) {
            int[] bitCounts = new int[24];
            for (int num : candidates) {
                for (int i = 0; num > 0; i++) {
                    bitCounts[i] += num & 1;
                    num >>= 1;
                }
            }
            int max = 0;
            for (int num : bitCounts) {
                max = Math.max(max, num);
            }
            return max;
        }
    }
}
