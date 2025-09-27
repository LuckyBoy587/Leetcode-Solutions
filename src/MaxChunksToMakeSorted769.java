public class MaxChunksToMakeSorted769 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxChunksToSorted(new int[]{1, 2, 0, 3, 4}));
    }

    private static class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length, res = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, arr[i]);
                if (max == i) ++res;
            }
            return res;
        }
    }
}
