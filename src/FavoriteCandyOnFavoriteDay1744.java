public class FavoriteCandyOnFavoriteDay1744 {
    private static class Solution {
        public boolean[] canEat(int[] candiesCount, int[][] queries) {
            int n = candiesCount.length;
            int[] prefixSum = new int[n];
            prefixSum[0] = candiesCount[0];

            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + candiesCount[i];
            }

            boolean[] result = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int favType = queries[i][0];
                int favDay = queries[i][1];
                int maxPerDay = queries[i][2];

                int minEatable = favDay + 1;
                int maxEatable = (favDay + 1) * maxPerDay;

                int start = favType == 0 ? 0: prefixSum[favType - 1];
                int end = prefixSum[favType] - 1;
                result[i] = maxEatable >= start && minEatable <= end;
            }

            return result;
        }
    }
}
