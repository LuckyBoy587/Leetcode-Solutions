import java.util.List;

public class KthSmallestProduct2040 {
    private static class Solution {
        public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
            return 0;
        }

        public int countPairs(List<Integer> arr, long maxProduct) {
            int count = 0;
            for (int start = 0; start < arr.size(); start++) {
                int left = start, right = arr.size() - 1;
                int res = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    long currProduct = (long) arr.get(start) * arr.get(mid);
                    if (currProduct <= maxProduct) {
                        res = left;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                if (res != -1) {
                    count += res - start;
                }
            }
            return count;
        }
    }
}
