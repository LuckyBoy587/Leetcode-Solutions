import java.util.ArrayList;
import java.util.List;

public class MakeLargeIsland827 {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 0}, {0, 1}};
        System.out.println(new Solution().largestIsland(matrix1));
    }
    private static class Solution {
        int[][] island;
        int m, n;
        int currIslandIndex = 1;
        List<Integer> islandLength = new ArrayList<>();

        public int largestIsland(int[][] grid) {
            islandLength.add(0);
            int res = 1;
            m = grid.length;
            n = grid[0].length;
            island = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        int currLen = dfs(grid, i, j);
                        res = Math.max(res, currLen);
                        islandLength.add(currLen);
                        currIslandIndex++;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) continue;
                    int currSum = getConnectedSum(grid, i, j);
                    res = Math.max(res, currSum);
                }
            }

            return res;
        }

        private int getConnectedSum(int[][] grid, int i, int j) {
            int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            List<Integer> connectableIslands = new ArrayList<>();
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni < 0 || ni == m || nj < 0 || nj == n) continue;
                if (grid[ni][nj] == 1 && !connectableIslands.contains(island[ni][nj])) {
                    connectableIslands.add(island[ni][nj]);
                }
            }

            int currSum = 1;
            for (int islandIndex: connectableIslands) {
                currSum += islandLength.get(islandIndex);
            }
            return currSum;
        }

        public int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || island[i][j] != 0) return 0;
            grid[i][j] = 0;
            island[i][j] = currIslandIndex;
            int curr = dfs(grid, i + 1, j) +
                    dfs(grid, i - 1, j) +
                    dfs(grid, i, j + 1) +
                    dfs(grid, i, j - 1) + 1;
            grid[i][j] = 1;
            return curr;
        }
    }
}
