import java.util.LinkedList;
import java.util.Queue;

public class MaximumNumberOfMovesInGrid2684 {
    private static class Solution {
        static class Node {
            int i, j;

            public Node(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
        public int maxMoves(int[][] grid) {
            Queue<Node> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                queue.offer(new Node(i, 0));
            }
            int level;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for (level = 0; !queue.isEmpty(); level++) {
                int size = queue.size();
                while (size-- > 0) {
                    Node curr = queue.poll();
                    int nextCol = curr.j + 1;
                    if (nextCol == n) return n - 1;
                    for (int rowStep = -1 ; rowStep <= 1 ; rowStep++) {
                        int nextRow = nextCol + rowStep;
                        if (nextRow >= 0 && nextRow < m && grid[nextRow][nextCol] > grid[curr.i][curr.j] && !visited[nextRow][nextCol]) {
                            queue.offer(new Node(nextRow, nextCol));
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }

            return level;
        }
    }
}
