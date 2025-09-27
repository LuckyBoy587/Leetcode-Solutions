public class SplitArray2270 {
    public static void main(String[] args) {
        int[] arr = {10, 4, -8, 7};
        System.out.println(new Solution().waysToSplitArray(arr));
    }

    private static class Solution {
        public int waysToSplitArray(int[] nums) {
            long total = 0;
            for (int num : nums) {
                total += num;
            }

            long prefix = 0;
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                prefix += nums[i];
                if (prefix >= total - prefix) {
                    count++;
                }
            }
            return count;
        }
    }
}
