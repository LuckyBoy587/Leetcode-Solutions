import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(new Solution().pacificAtlantic(heights));
    }
    private static class Solution {
        Boolean[][] memoPacific;
        Boolean[][] memoAtlantic;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] pacificVisited;
        boolean[][] atlanticVisited;
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            memoPacific = new Boolean[m][n];
            memoAtlantic = new Boolean[m][n];
            pacificVisited = new boolean[m][n];
            atlanticVisited = new boolean[m][n];
            List<List<Integer>> res = new ArrayList<>();
            bfsPacific(heights);
            bfsAtlantic(heights);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                        res.add(List.of(i, j));
                    }
                }
            }

            return res;
        }

        private void bfsAtlantic(int[][] height) {
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < height.length; i++) {
                queue.offer(new int[]{i, height[0].length - 1});
            }

            for (int j = 0; j < height[0].length; j++) {
                queue.offer(new int[]{height.length - 1, j});
            }

            visitIsland(height, queue, atlanticVisited);
        }

        private void bfsPacific(int[][] height) {
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < height.length; i++) {
                queue.offer(new int[]{i, 0});
            }

            for (int j = 0; j < height[0].length; j++) {
                queue.offer(new int[]{0, j});
            }

            visitIsland(height, queue, pacificVisited);
        }

        private void visitIsland(int[][] height, Queue<int[]> queue, boolean[][] atlanticVisited) {
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currI = curr[0];
                int currJ = curr[1];
                if (atlanticVisited[currI][currJ]) continue;
                atlanticVisited[currI][currJ] = true;

                for (int[] dir : dirs) {
                    int ni = currI + dir[0];
                    int nj = currJ + dir[1];
                    if (ni < 0 || nj < 0 || ni == height.length || nj == height[0].length) continue;
                    if (height[ni][nj] < height[currI][currJ]) continue;
                    if (!atlanticVisited[ni][nj]) {
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }
        }
    }
}
