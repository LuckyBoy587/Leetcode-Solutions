import java.util.Arrays;

public class RotatingTheBox1861 {
    public static void main(String[] args) {
        char[][] pattern = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        char[][] expectedPattern = {
                {'.', '#', '#'},
                {'.', '#', '#'},
                {'#', '#', '*'},
                {'#', '*', '.'},
                {'#', '.', '*'},
                {'#', '.', '.'}
        };
        System.out.println(Arrays.deepEquals(new Solution().rotateTheBox(pattern), expectedPattern));
    }
    private static class Solution {
        public char[][] rotateTheBox(char[][] box) {
            int m = box.length;
            int n = box[0].length;
            final char STONE = '#', OBSTACLE = '*', EMPTY = '.';
            char[][] rotatedBox = new char[n][m];

            for (int i = 0; i < m; i++) {
                int fillStart = n - 1;
                int rotatedI = m - i - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (box[i][j] == STONE) {
                        rotatedBox[fillStart--][rotatedI] = STONE;
                    } else if (box[i][j] == OBSTACLE) {
                        rotatedBox[j][rotatedI] = OBSTACLE;
                        fillStart = j - 1;
                    } else {
                        rotatedBox[j][rotatedI] = EMPTY;
                    }
                }

                while (fillStart >= 0) {
                    rotatedBox[fillStart--][rotatedI] = EMPTY;
                }
            }

            return rotatedBox;
        }
    }
}
