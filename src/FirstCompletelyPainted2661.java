public class FirstCompletelyPainted2661 {
    private static class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[] rowCount = new int[m];
            int[] colCount = new int[n];
            Position[] positions = new Position[m * n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    positions[mat[i][j]] = new Position(i, j);
                }
            }

            for (int x = 0; x < arr.length; x++) {
                Position p = positions[arr[x]];
                int i = p.i;
                int j = p.j;
                rowCount[i]++;
                colCount[j]++;

                if (rowCount[i] == n || colCount[j] == m) {
                    return x;
                }
            }
            return -1;
        }

        static class Position {
            int i, j;

            public Position(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
    }
}
