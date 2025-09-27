import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland695 {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = {
                {0, 1},
                {1, 1},
                {1, 0}
        };

        System.out.println(new Solution().maxAreaOfIsland(twoDimensionalArray));
    }
    private static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int maxLen = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        maxLen = Math.max(maxLen, getMaxArea(grid, i, j));
                    }
                }
            }

            return maxLen;
        }

        public int getMaxArea(int[][] grid, int i, int j) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            grid[i][j] = 0;
            Queue<Index> q = new LinkedList<>();
            q.offer(new Index(i, j));

            while (!q.isEmpty()) {
                res++;
                Index curr = q.poll();
                int newI = curr.i;
                int newJ = curr.j;

                if (newI - 1 >= 0 && grid[newI - 1][newJ] == 1) {
                    grid[newI - 1][newJ] = 0;
                    q.offer(new Index(newI - 1, newJ));
                }
                if (newJ - 1 >= 0 && grid[newI][newJ - 1] == 1) {
                    grid[newI][newJ - 1] = 0;
                    q.offer(new Index(newI, newJ - 1));
                }
                if (newI + 1 < m && grid[newI + 1][newJ] == 1) {
                    grid[newI + 1][newJ] = 0;
                    q.offer(new Index(newI + 1, newJ));
                }
                if (newJ + 1 < n && grid[newI][newJ + 1] == 1) {
                    grid[newI][newJ + 1] = 0;
                    q.offer(new Index(newI, newJ + 1));
                }
            }

            return res;
        }
    }

    static class Index {
        int i;
        int j;

        public Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
