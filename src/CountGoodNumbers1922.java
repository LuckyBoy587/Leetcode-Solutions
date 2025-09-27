public class CountGoodNumbers1922 {
    public static void main(String[] args) {
        System.out.println(new Solution().countGoodNumbers(50));
    }
    private static class Solution {
        public int countGoodNumbers(long n) {
            int MOD = 1000000007;
            return (int) ((Math.pow(5, ((double) n / 2) + (n & 1)) * Math.pow(4, (double) n / 2)) % MOD);
        }
    }
}
