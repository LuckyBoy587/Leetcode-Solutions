public class BitwiseXOROfPairs2425 {
    private static class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int res = 0;
            int m = nums1.length;
            int n = nums2.length;

            if (m % 2 == 0 && n % 2 == 0) return 0;
            if (m % 2 != 0 && n % 2 != 0) {
                return getArrayXOR(nums1) ^ getArrayXOR(nums2);
            }
            if (m % 2 == 0) {
                return getArrayXOR(nums2);
            }
            return getArrayXOR(nums1);
        }

        private int getArrayXOR(int[] arr) {
            int res = 0;
            for (int num : arr) {
                res ^= num;
            }
            return res;
        }
    }
}
