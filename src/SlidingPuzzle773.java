import java.util.*;

public class SlidingPuzzle773 {
    public static void main(String[] args) {
        int[][] myArray = {{1, 2, 3}, {5, 4, 0}};
        System.out.println(new Solution().slidingPuzzle(myArray));
    }

    private static class Solution {
        private static int[][] deepCopy2DArray(int[][] originalArray) {
            int[][] newArray = new int[originalArray.length][];
            for (int i = 0; i < originalArray.length; i++) {
                newArray[i] = Arrays.copyOf(originalArray[i], originalArray[i].length);
            }
            return newArray;
        }

        public int slidingPuzzle(int[][] board) {
            Set<Board> visited = new HashSet<>();
            Queue<Board> queue = new LinkedList<>();
            Board root = new Board(board, getEmptyIndex(board), 0);
            queue.offer(root);
            visited.add(root);

            while (!queue.isEmpty()) {
                Board currBoard = queue.poll();
                if (currBoard.isSolved()) return currBoard.count;
                Board topSwap = currBoard.swapTop();
                if (topSwap != null && !visited.contains(topSwap)) {
                    queue.offer(topSwap);
                    visited.add(topSwap);
                }

                Board bottomSwap = currBoard.swapBottom();
                if (bottomSwap != null && !visited.contains(bottomSwap)) {
                    queue.offer(bottomSwap);
                    visited.add(bottomSwap);
                }

                Board leftSwap = currBoard.swapLeft();
                if (leftSwap != null && !visited.contains(leftSwap)) {
                    queue.offer(leftSwap);
                    visited.add(leftSwap);
                }

                Board rightSwap = currBoard.swapRight();
                if (rightSwap != null && !visited.contains(rightSwap)) {
                    queue.offer(rightSwap);
                    visited.add(rightSwap);
                }
            }
            return -1;
        }

        private Index getEmptyIndex(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) {
                        return new Index(i, j);
                    }
                }
            }
            return new Index(-1, -1);
        }

        static class Board {
            private static final int[][] SOLVED_BOARD = {{1, 2, 3}, {4, 5, 0}};
            Index emptyIndex;
            int[][] board;
            int count;

            Board(int[][] board, Index emptyIndex, int count) {
                this.board = board;
                this.emptyIndex = emptyIndex;
                this.count = count;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj.getClass() != this.getClass()) return false;
                Board other = (Board) obj;
                return Arrays.deepEquals(this.board, other.board);
            }

            @Override
            public int hashCode() {
                return Arrays.deepHashCode(board);
            }

            public Board swapTop() {
                if (emptyIndex.i == 0) return null;
                int[][] copy = Solution.deepCopy2DArray(board);
                int temp = copy[emptyIndex.i][emptyIndex.j];
                copy[emptyIndex.i][emptyIndex.j] = copy[emptyIndex.i - 1][emptyIndex.j];
                copy[emptyIndex.i - 1][emptyIndex.j] = temp;
                return new Board(copy, new Index(emptyIndex.i - 1, emptyIndex.j), count + 1);
            }

            public Board swapBottom() {
                if (emptyIndex.i + 1 == board.length) return null;
                int[][] copy = Solution.deepCopy2DArray(board);
                int temp = copy[emptyIndex.i][emptyIndex.j];
                copy[emptyIndex.i][emptyIndex.j] = copy[emptyIndex.i + 1][emptyIndex.j];
                copy[emptyIndex.i + 1][emptyIndex.j] = temp;
                return new Board(copy, new Index(emptyIndex.i + 1, emptyIndex.j), count + 1);
            }

            public Board swapLeft() {
                if (emptyIndex.j == 0) return null;
                int[][] copy = Solution.deepCopy2DArray(board);
                int temp = copy[emptyIndex.i][emptyIndex.j];
                copy[emptyIndex.i][emptyIndex.j] = copy[emptyIndex.i][emptyIndex.j - 1];
                copy[emptyIndex.i][emptyIndex.j - 1] = temp;
                return new Board(copy, new Index(emptyIndex.i, emptyIndex.j - 1), count + 1);
            }

            public Board swapRight() {
                if (emptyIndex.j + 1 == board[0].length) return null;
                int[][] copy = Solution.deepCopy2DArray(board);
                int temp = copy[emptyIndex.i][emptyIndex.j];
                copy[emptyIndex.i][emptyIndex.j] = copy[emptyIndex.i][emptyIndex.j + 1];
                copy[emptyIndex.i][emptyIndex.j + 1] = temp;
                return new Board(copy, new Index(emptyIndex.i, emptyIndex.j + 1), count + 1);
            }

            public boolean isSolved() {
                return Arrays.deepEquals(board, SOLVED_BOARD);
            }
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
