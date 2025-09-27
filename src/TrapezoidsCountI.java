import java.util.HashMap;

public class TrapezoidsCountI {
    private static class Solution {
        int MOD = 1000000007;
        public int countTrapezoids(int[][] points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] point : points) {
                map.merge(point[1], 1, Integer::sum);
            }

            int[] combs = new int[map.size()];
            int index = 0;
            for (int key : map.keySet()) {
                combs[index++] = nCr(map.get(key));
            }

            int res = 0;
            for (int i = 1; i < combs.length; i++) {
                for (int j = 0; j < i; j++) {
                    res = (res + combs[i] * combs[j]) % MOD;
                }
            }

            return res % MOD;
        }

        private int nCr(int n) {
            if (n < 2) return 0;
            return n * (n - 1) / 2;
        }
    }
}
