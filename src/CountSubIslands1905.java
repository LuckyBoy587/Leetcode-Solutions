import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands1905 {
    private static class Solution {
        int m, n;
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            m = grid1.length;
            n = grid1[0].length;
            int count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid2[i][j] == 1) {
                        Queue<Index> q = new LinkedList<>();
                        q.offer(new Index(i, j));

                        boolean res = true;
                        while (!q.isEmpty()) {
                            Index curr = q.poll();
                            if (grid2[curr.i][curr.j] == 0) continue;
                            grid2[curr.i][curr.j] = 0;

                            if (withinBounds(curr.i, curr.j - 1)) {
                                q.offer(new Index(curr.i, curr.j - 1));
                            }

                            if (withinBounds(curr.i, curr.j + 1)) {
                                q.offer(new Index(curr.i, curr.j + 1));
                            }

                            if (withinBounds(curr.i - 1, curr.j)) {
                                q.offer(new Index(curr.i - 1, curr.j));
                            }

                            if (withinBounds(curr.i + 1, curr.j)) {
                                q.offer(new Index(curr.i + 1, curr.j));
                            }

                            if (grid1[curr.i][curr.j] == 0) res = false;
                        }
                        if (res) count++;
                    }
                }
            }
            return count;
        }

        private boolean withinBounds(int row, int col) {
            return row >= 0 && row < m && col >= 0 && col < n;
        }

        static class Index {
            int i, j;

            Index(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
    }
}
