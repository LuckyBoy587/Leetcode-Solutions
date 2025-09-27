public class MinimumArrayEnd3133 {
    public static void main(String[] args) {
        System.out.println(new Solution().minEnd(6715154, 7193485));
    }
    private static class Solution {
        public long minEnd(int n, int x) {
            --n;
            long res = x;
            for (long pos = 1; n > 0; pos <<= 1) {
                if ((res & pos) == 0) {
                    res |= (n & 1L) * pos;
                    n >>= 1;
                }
            }
            return res;
        }
    }
}
