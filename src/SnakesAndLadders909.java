import java.util.Arrays;
import java.util.PriorityQueue;

public class SnakesAndLadders909 {
    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1},
                {-1, 9, 8},
                {-1, 8, 9}
        };

        Solution solution = new Solution();
        int result = solution.snakesAndLadders(board);
        System.out.println("Minimum number of rolls to reach the end: " + result);
    }

    private static class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            PositionBuilder builder = new PositionBuilder(n);
            int[][] rolls = new int[n][n];
            for (int[] row : rolls) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            rolls[n - 1][0] = 0;
            PriorityQueue<Position> pq = new PriorityQueue<>((p1, p2) -> {
                if (rolls[p1.i][p1.j] != rolls[p2.i][p2.j]) {
                    return Integer.compare(rolls[p1.i][p1.j], rolls[p2.i][p2.j]);
                }
                return Integer.compare(p2.cellValue, p1.cellValue);
            });
            pq.add(builder.build(1));

            while (!pq.isEmpty()) {
                Position curr = pq.poll();
                int currRolls = rolls[curr.i][curr.j];
                if (curr.cellValue == n * n) return currRolls;
                for (int cellValue = curr.cellValue + 1; cellValue <= Math.min(curr.cellValue + 6, n * n); cellValue++) {
                    Position next = builder.build(cellValue);
                    if (board[next.i][next.j] != -1) {
                        next = builder.build(board[next.i][next.j]);
                    }

                    if (currRolls + 1 < rolls[next.i][next.j]) {
                        rolls[next.i][next.j] = currRolls + 1;
                        pq.add(next);
                    }
                }
            }

            return -1;
        }

        static class PositionBuilder {
            int n;

            public PositionBuilder(int n) {
                this.n = n;
            }

            public Position build(int cellValue) {
                int i = n - 1 - (cellValue - 1) / n;
                int j = (cellValue - 1) % n;
                if (i % 2 == n % 2) j = n - 1 - j;
                return new Position(cellValue, i, j);
            }
        }

        static class Position {
            int i;
            int j;
            int cellValue;

            public Position(int cellValue, int i, int j) {
                this.cellValue = cellValue;
                this.i = i;
                this.j = j;
            }

            @Override
            public String toString() {
                return "Position{" +
                        "cellValue=" + cellValue +
                        ", i=" + i +
                        ", j=" + j +
                        '}';
            }
        }
    }
}
