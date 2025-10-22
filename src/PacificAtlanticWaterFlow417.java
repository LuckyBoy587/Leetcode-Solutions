void main() {
    int[][] testCase = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
    };
    Solution solution = new Solution();
    List<List<Integer>> result = solution.pacificAtlantic(testCase);
    System.out.println("Result: " + result);
}

private static class Solution {
    boolean[][] visitedPacific;
    boolean[][] visitedAtlantic;
    boolean[][] computedPacific;
    boolean[][] computedAtlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        visitedPacific = new boolean[m][n];
        visitedAtlantic = new boolean[m][n];
        computedPacific = new boolean[m][n];
        computedAtlantic = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfsPacific(heights, i, j) && dfsAtlantic(heights, i, j)) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private boolean dfsPacific(int[][] heights, int i, int j) {
        if (i == 0 || j == 0) return true;
        if (i == heights.length || j == heights[0].length) return false;
        if (computedPacific[i][j]) return visitedPacific[i][j];

        int currHeight = heights[i][j];
        if (currHeight == Integer.MAX_VALUE) return false;
        heights[i][j] = Integer.MAX_VALUE;

        boolean top = heights[i - 1][j] <= currHeight && dfsPacific(heights, i - 1, j);
        boolean left = heights[i][j - 1] <= currHeight && dfsPacific(heights, i, j - 1);
        boolean bottom = i + 1 < heights.length && heights[i + 1][j] <= currHeight && dfsPacific(heights, i + 1, j);
        boolean right = j + 1 < heights[0].length && heights[i][j + 1] <= currHeight && dfsPacific(heights, i, j + 1);

        heights[i][j] = currHeight;
        visitedPacific[i][j] = top || left || bottom || right;
        computedPacific[i][j] = true;
        return visitedPacific[i][j];
    }

    private boolean dfsAtlantic(int[][] heights, int i, int j) {
        if (i == heights.length - 1 || j == heights[0].length - 1) return true;
        if (i < 0 || j < 0) return false;
        if (computedAtlantic[i][j]) return visitedAtlantic[i][j];

        int currHeight = heights[i][j];
        if (currHeight == Integer.MAX_VALUE) return false;
        heights[i][j] = Integer.MAX_VALUE;

        boolean top = i - 1 >= 0 && heights[i - 1][j] <= currHeight && dfsAtlantic(heights, i - 1, j);
        boolean left = j - 1 >= 0 && heights[i][j - 1] <= heights[i][j] && dfsAtlantic(heights, i, j - 1);
        boolean bottom = i + 1 < heights.length && heights[i + 1][j] <= currHeight && dfsAtlantic(heights, i + 1, j);
        boolean right = j + 1 < heights[0].length && heights[i][j + 1] <= currHeight && dfsAtlantic(heights, i, j + 1);

        heights[i][j] = currHeight;
        visitedAtlantic[i][j] = top || left || bottom || right;
        computedAtlantic[i][j] = true;
        return visitedAtlantic[i][j];
    }
}