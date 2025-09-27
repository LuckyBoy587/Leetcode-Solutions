import java.util.Arrays;

public class FindChampionII2924 {
    public static void main(String[] args) {
        int[][] twoDArray = {{0, 2}, {1, 3}, {1, 2}};
        System.out.println(new Solution().findChampion(4, twoDArray));
    }
    private static class Solution {
        public int findChampion(int n, int[][] edges) {
            boolean[] isStart = new boolean[n];
            Arrays.fill(isStart, true);
            boolean[] isWeak = new boolean[n];

            for (int[] edge : edges) {
                int end = edge[1];

                isStart[end] = false;
                isWeak[end] = true;
            }

            int res = -1;
            for (int i = 0; i < n; i++) {
                if (isStart[i] && !isWeak[i]) {
                    if (res != -1) return -1;
                    res = i;
                }
            }
            return res;
        }
    }
}
