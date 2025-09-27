public class FindMinimumArea3197 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 1, 1, 0, 0}
        };
        Solution solution = new Solution();
        System.out.println(solution.minimumSum(grid));
    }

    private static class Solution {
        int res = Integer.MAX_VALUE;

        public int minimumSum(int[][] grid) {
            findSum(grid, reduce(grid, new Rect(0, 0, grid.length, grid[0].length)), 0, 2);
            return res;
        }

        private void findSum(int[][] grid, Rect rect, int currArea, int cutsRemaining) {
            if (cutsRemaining == 0) {
                res = Math.min(res, currArea + rect.area());
                return;
            }
            for (int verticalCutIndex = rect.topJ + 1; verticalCutIndex < rect.bottomJ; verticalCutIndex++) {
                Rect leftRect = reduce(grid, new Rect(rect.topI, rect.topJ, rect.bottomI, verticalCutIndex));
                Rect rightRect = reduce(grid, new Rect(rect.topI, verticalCutIndex, rect.bottomI, rect.bottomJ));
                findSum(grid, leftRect, currArea + rightRect.area(), cutsRemaining - 1);
                findSum(grid, rightRect, currArea + leftRect.area(), cutsRemaining - 1);
            }

            for (int horizontalCutIndex = rect.topI + 1; horizontalCutIndex < rect.bottomI; horizontalCutIndex++) {
                Rect topRect = reduce(grid, new Rect(rect.topI, rect.topJ, horizontalCutIndex, rect.bottomJ));
                Rect bottomRect = reduce(grid, new Rect(horizontalCutIndex, rect.topJ, rect.bottomI, rect.bottomJ));
                findSum(grid, topRect, currArea + bottomRect.area(), cutsRemaining - 1);
                findSum(grid, bottomRect, currArea + topRect.area(), cutsRemaining - 1);
            }
        }

        private Rect reduce(int[][] grid, Rect rect) {
            int newTopI = Integer.MAX_VALUE;
            int newTopJ = Integer.MAX_VALUE;
            int newBottomI = Integer.MIN_VALUE;
            int newBottomJ = Integer.MIN_VALUE;

            for (int i = rect.topI; i < rect.bottomI; i++) {
                for (int j = rect.topJ; j < rect.bottomJ; j++) {
                    if (grid[i][j] == 1) {
                        newTopI = Math.min(newTopI, i);
                        newTopJ = Math.min(newTopJ, j);

                        newBottomI = Math.max(newBottomI, i);
                        newBottomJ = Math.max(newBottomJ, j);
                    }
                }
            }
            if (newTopI == Integer.MAX_VALUE) {
                return new Rect(rect.topI, rect.topJ, rect.topI + 1, rect.topJ + 1);
            }

            return new Rect(newTopI, newTopJ, newBottomI + 1, newBottomJ + 1);
        }

        static class Rect {
            int topI, topJ, bottomI, bottomJ;

            public Rect(int topI, int topJ, int bottomI, int bottomJ) {
                this.topI = topI;
                this.topJ = topJ;
                this.bottomI = bottomI;
                this.bottomJ = bottomJ;
            }

            public int area() {
                return (bottomI - topI) * (bottomJ - topJ);
            }
        }
    }
}
