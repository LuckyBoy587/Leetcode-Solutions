public class KthSmallestLexographical440 {
    private static class Solution {
        int res = 0;
        int count = 0;
        public int findKthNumber(int n, int k) {
            count = k;
            for (int start = 1; start <= 9 && count > 0; start++) {
                dfs(start, n);
            }

            return res;
        }

        public void dfs(int num, int max) {
            res = num;
            count--;
            for (int digit = 0;count > 0 && digit <= 9 && num * 10 + digit <= max; digit++) {
                dfs(num * 10 + digit, max);
            }
        }
    }
}
