public class SudokuSolver37 {
    private static class Solution {
        public void solveSudoku(char[][] board) {
            dfs(board, 0, 0);
        }

        public boolean dfs(char[][] board, int row, int col) {
            if (row == board.length) return true;
            if (col == board.length) {
                return dfs(board, row + 1, 0);
            }

            if (board[row][col] != '.') {
                return dfs(board, row, col + 1);
            }

            for (char num = '1'; num <= '9'; num++) {
                if (isValid(board, row, col, num)) {
                    board[row][col] = num;

                    if (dfs(board, row, col + 1)) {
                        return true;
                    }

                    board[row][col] = '.';
                }
            }

            return false;
        }

        private boolean isValid(char[][] board, int row, int col, char num) {
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == num) {
                    return false;
                }
            }

            for (int j = 0; j < 9; j++) {
                if (board[row][j] == num) {
                    return false;
                }
            }

            int boxI = (row / 3) * 3;
            int boxJ = (col / 3) * 3;

            for (int iStep = 0; iStep < 3; iStep++) {
                for (int jStep = 0; jStep < 3; jStep++) {
                    if (board[boxI + iStep][boxJ + jStep] == num) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
