import java.util.Arrays;

public class PlatesBetweenCandles2055 {
    public static void main(String[] args) {
        int[][] queries = {{2, 5}};
        System.out.println(Arrays.toString(new Solution().platesBetweenCandles("**|**|***|", queries)));
    }

    private static class Solution {
        static final char PLATE = '*';
        static final char CANDLE = '|';

        public int[] platesBetweenCandles(String s, int[][] queries) {
            char[] symbols = s.toCharArray();
            int n = s.length();
            int[] prefixPlates = new int[n];
            prefixPlates[0] = symbols[0] == PLATE ? 1 : 0;
            int[] suffixPlates = new int[n];
            suffixPlates[n - 1] = symbols[n - 1] == PLATE ? 1 : 0;

            int[] closestLeftCandle = new int[n];
            closestLeftCandle[0] = symbols[0] == CANDLE ? 0 : -1;
            for (int i = 1; i < n; i++) {
                closestLeftCandle[i] = symbols[i] == CANDLE ? i : closestLeftCandle[i - 1];
            }

            int[] closestRightCandle = new int[n];
            closestRightCandle[n - 1] = symbols[n - 1] == CANDLE ? 0 : -1;
            for (int i = n - 2; i >= 0; i--) {
                closestRightCandle[i] = symbols[i] == CANDLE ? i : closestRightCandle[i + 1];
            }

            for (int i = 1; i < n; i++) {
                prefixPlates[i] = prefixPlates[i - 1] + (symbols[i] == PLATE ? 1 : 0);
            }

            for (int i = n - 2; i >= 0; i--) {
                suffixPlates[i] = suffixPlates[i + 1] + (symbols[i] == PLATE ? 1 : 0);
            }

            int totalPlates = suffixPlates[0];
            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int left = queries[i][0];
                int right = queries[i][1];
                left = closestRightCandle[left];
                right = closestLeftCandle[right];
                if (left != -1 && right != -1 && left != right) {
                    result[i] = totalPlates - prefixPlates[left] - suffixPlates[right];
                }
            }

            return result;
        }
    }
}
