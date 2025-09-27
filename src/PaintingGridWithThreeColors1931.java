import java.util.*;

public class PaintingGridWithThreeColors1931 {
    public static void main(String[] args) {
        PaintingGridWithThreeColors1931.Solution solution = new PaintingGridWithThreeColors1931.Solution();
        int m = 3, n = 3;
        System.out.println("Result for grid " + m + "x" + n + ": " + solution.colorTheGrid(m, n));
    }
    private static class Solution {
        static final int MOD = 1_000_000_007;
        List<int[]> validColumns = new ArrayList<>();
        Map<Integer, List<Integer>> transitions = new HashMap<>();

        public int colorTheGrid(int m, int n) {
            generateValidColumns(new int[m], 0, m);

            // Precompute compatible transitions
            for (int i = 0; i < validColumns.size(); i++) {
                for (int j = 0; j < validColumns.size(); j++) {
                    if (areCompatible(validColumns.get(i), validColumns.get(j))) {
                        transitions.computeIfAbsent(i, _ -> new ArrayList<>()).add(j);
                    }
                }
            }

            long[] dp = new long[validColumns.size()];
            Arrays.fill(dp, 1);  // First column: all valid patterns are okay

            for (int col = 1; col < n; col++) {
                long[] newDp = new long[validColumns.size()];
                for (int prev = 0; prev < validColumns.size(); prev++) {
                    for (int next : transitions.get(prev)) {
                        newDp[next] = (newDp[next] + dp[prev]) % MOD;
                    }
                }
                dp = newDp;
            }

            long total = 0;
            for (long count : dp) {
                total = (total + count) % MOD;
            }
            return (int) total;
        }

        // Generate all valid colorings of a single column of height m
        private void generateValidColumns(int[] current, int idx, int m) {
            if (idx == m) {
                validColumns.add(Arrays.copyOf(current, m));
                return;
            }

            for (int color = 0; color < 3; color++) {
                if (idx == 0 || current[idx - 1] != color) {
                    current[idx] = color;
                    generateValidColumns(current, idx + 1, m);
                }
            }
        }

        // Check if two columns are compatible (no same colors in the same row)
        private boolean areCompatible(int[] a, int[] b) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == b[i]) return false;
            }
            return true;
        }
    }

}