public class CountGoodTriplets2179 {
    private static class Solution {
        public long goodTriplets(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] ind = new int[n];
            for (int i = 0; i < n; i++) {
                ind[nums2[i]] = i + 1;
            }

            BinaryIndexedTree leftTree = new BinaryIndexedTree(n);
            leftTree.update(ind[nums1[0]], 1);
            long[] leftCount = new long[n];
            for (int mid = 1; mid < n; mid++) {
                int midIndex = ind[nums1[mid]];
                leftCount[mid] = leftTree.query(midIndex - 1);
                leftTree.update(midIndex, 1);
            }

            BinaryIndexedTree rightTree = new BinaryIndexedTree(n);
            rightTree.update(ind[nums1[n - 1]], 1);
            long[] rightCount = new long[n];
            for (int mid = n - 2; mid >= 0; mid--) {
                int midIndex = ind[nums1[mid]];
                rightCount[mid] = rightTree.query(n) - rightTree.query(midIndex);
                rightTree.update(midIndex, 1);
            }

            long res = 0;
            for (int i = 1; i < n - 1; i++) {
                res += leftCount[i] * rightCount[i];
            }
            return res;
        }

        static class BinaryIndexedTree {
            long[] bits;
            BinaryIndexedTree(int n) {
                bits = new long[n + 1];
            }

            public void update(int index, int val) {
                while (index < bits.length) {
                    bits[index] += val;
                    index += index & -index;
                }
            }

            public long query(int index) {
                long res = 0;
                while (index > 0) {
                    res += bits[index];
                    index -= index & -index;
                }
                return res;
            }
        }
    }
}
