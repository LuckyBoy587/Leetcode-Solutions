public class ColorTheArray2672 {
    private static class Solution {
        public int[] colorTheArray(int n, int[][] queries) {
            int[] res = new int[queries.length];
            int[] colors = new int[n];
            int currCount = 0;
            for (int i = 0; i < queries.length; i++) {
                int pos = queries[i][0];
                int color = queries[i][1];
                if (colors[pos] != color) {
                    int leftColor = pos > 0 ? colors[pos - 1] : -1;
                    int rightColor = pos + 1 < n ? colors[pos + 1] : -1;
                    if (colors[pos] > 0) {
                        if (leftColor == colors[pos]) currCount--;
                        if (rightColor == colors[pos]) currCount--;
                    }
                    colors[pos] = color;
                    if (leftColor == colors[pos]) currCount++;
                    if (rightColor == colors[pos]) currCount++;
                }
                res[i] = currCount;
            }
            return res;
        }
    }
}
