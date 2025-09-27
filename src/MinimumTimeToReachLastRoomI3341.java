import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimeToReachLastRoomI3341 {
    private static class Solution {
        public int minTimeToReach(int[][] moveTime) {
            int m = moveTime.length;
            int n = moveTime[0].length;
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            int[][] reachTime = new int[m][n];
            for (int[] row: reachTime) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            reachTime[0][0] = 0;

            PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(p -> reachTime[p.i][p.j]));
            pq.offer(new Position(0, 0, 0));

            while (!pq.isEmpty()) {
                Position curr = pq.poll();
                if (curr.i + 1 == m && curr.j + 1 == n) break;
                if (reachTime[curr.i][curr.j] < curr.time) continue;

                for (int[] direction : directions) {
                    int newI = curr.i + direction[0];
                    int newJ = curr.j + direction[1];

                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        int newReachTime = Math.max(curr.time, moveTime[newI][newJ]) + 1;
                        if (newReachTime < reachTime[newI][newJ]) {
                            reachTime[newI][newJ] = newReachTime;
                            pq.offer(new Position(newI, newJ, newReachTime));
                        }
                    }
                }
            }

            for (int[] row: reachTime) {
                System.out.println(Arrays.toString(row));
            }

            return reachTime[m - 1][n - 1];
        }

        static class Position {
            int i;
            int j;
            int time;

            public Position(int i, int j, int time) {
                this.i = i;
                this.j = j;
                this.time = time;
            }
        }
    }
}
