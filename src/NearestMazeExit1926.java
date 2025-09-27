import java.util.LinkedList;
import java.util.Queue;

public class NearestMazeExit1926 {
    public static void main(String[] args) {
        
    }
    private static class Solution {
        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length;
            int n = maze[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : dirs) {
                int ni = entrance[0] + dir[0];
                int nj = entrance[1] + dir[1];
                if (0 <= ni && ni < m && 0 <= nj && nj < n && maze[ni][nj] == '.') {
                    queue.offer(new int[]{ni, nj});
                    maze[ni][nj] = '+';
                }
            }
            maze[entrance[0]][entrance[1]] = '+';

            for (int minDist = 1; !queue.isEmpty(); ++minDist) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] curr = queue.poll();
                    int currI = curr[0], currJ = curr[1];
                    if (currI == 0 || currJ == 0 || currI == m - 1 || currJ == n - 1) return minDist;
                    maze[currI][currJ] = '+';
                    for (int[] dir : dirs) {
                        int ni = currI + dir[0];
                        int nj = currJ + dir[1];
                        if (0 <= ni && ni < m && 0 <= nj && nj < n && maze[ni][nj] == '.') {
                            queue.offer(new int[]{ni, nj});
                            maze[ni][nj] = '+';
                        }
                    }
                }
            }

            return -1;
        }
    }
}
