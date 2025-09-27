public class NumberOfCommonFactors2427 {
    private static class Solution {
        public int commonFactors(int a, int b) {
            if (b > a) return commonFactors(b, a);
            int count = 1;
            for (int i = 2; i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    count++;
                }
            }
            return count;
        }
    }
}
