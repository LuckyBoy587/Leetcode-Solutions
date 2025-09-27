public class KthLexographicNumber440 {
    private static class Solution {
        long res = 0;
        int k;
        public int findKthNumber(int n, int k) {
            this.k = k;
            search(0, n);
            return (int) res;
        }

        public void search(long n, int target) {
            res = n;
            n *= 10;
            for (int i = 0; i <= 9 && k > 0; i++) {
                if (i == 0 && n == 0) continue;
                if (n + i > target || n + i <= 0) break;
                k--;
                search(n + i, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(957747794, 424238336));
    }
}
