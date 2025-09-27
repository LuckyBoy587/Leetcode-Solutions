import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak1765 {
    public static void main(String[] args) {
        int[][] twoDArray = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(new Solution().highestPeak(twoDArray)));
    }
    private static class Solution {
        private final int[] directions = {0, 1, 0, -1, 0};
        public int[][] highestPeak(int[][] isWater) {
            int m = isWater.length;
            int n = isWater[0].length;

            int[][] res = new int[m][n];
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isWater[i][j] == 1) {
                        visited[i][j] = true;
                        queue.offer(new int[]{i, j, 0});
                    } else {
                        res[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                int currCost = cur[2] + 1;
                visited[i][j] = true;

                for (int x = 1; x <= 4; x++) {
                    int di = directions[x];
                    int dj = directions[x - 1];
                    int newI = i + di;
                    int newJ = j + dj;
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        if (currCost < res[newI][newJ]) {
                            res[newI][newJ] = currCost;
                            queue.offer(new int[]{newI, newJ, currCost});
                        }
                    }
                }
            }

            return res;
        }
    }
}
