import java.util.Arrays;
import java.util.Comparator;

public class MinimumLinesToRepresentChart2280 {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 4},
                {1, 2},
                {7, 8},
                {2, 3}
        };
        System.out.println(new Solution().minimumLines(arr));
    }
    private static class Solution {
        public int minimumLines(int[][] stockPrices) {
            if (stockPrices.length <= 1) return 0;
            Arrays.sort(stockPrices, Comparator.comparingInt(p -> p[0]));
            int res = 1;
            String prevSlope = getSlope(stockPrices[1], stockPrices[0]);
            for (int i = 2; i < stockPrices.length; i++) {
                String currSlope = getSlope(stockPrices[i], stockPrices[i - 1]);
                if (!currSlope.equals(prevSlope)) {
                    res++;
                }
                prevSlope = currSlope;
                System.out.println(prevSlope);
            }
            return res;
        }

        private String getSlope(int[] p1, int[] p2) {
            int numerator = p1[1] - p2[1];
            int denominator = p1[0] - p2[0];
            if (denominator < 0) {
                denominator *= -1;
                numerator *= -1;
            }
            int gcd = GCD(Math.abs(numerator), Math.abs(denominator));
            return (numerator / gcd) + "/" + (denominator / gcd);
        }

        private int GCD(int a, int b) {
            if (b == 0) return a;
            return GCD(b, a % b);
        }
    }
}
