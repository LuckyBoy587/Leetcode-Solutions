public class UniqueBST96 {
    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(19));
    }

    private static class Solution {
        private Integer[][] memo;

        public int numTrees(int n) {
            memo = new Integer[n + 1][n + 1];
            return countTrees(1, n);
        }

        private int countTrees(int start, int end) {
            if (start > end) {
                return 1;
            }
            if (memo[start][end] != null) {
                return memo[start][end];
            }
            int res = 0;
            for (int mid = start; mid <= end; mid++) {
                int leftCount = countTrees(start, mid - 1);
                int rightCount = countTrees(mid + 1, end);
                res += leftCount * rightCount;
            }

            return memo[start][end] = res;
        }
    }
}
