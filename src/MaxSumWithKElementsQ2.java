import java.util.PriorityQueue;

public class MaxSumWithKElementsQ2 {
    private static class Solution {
        public long maxSum(int[][] grid, int[] limits, int k) {
            PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e2.val - e1.val);
            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pq.add(new Element(i, grid[i][j]));
                }
            }

            int res = 0;
            while (!pq.isEmpty() && k > 0) {
                Element curr = pq.poll();
                if (limits[curr.index] > 0) {
                    res += curr.val;
                    limits[curr.index]--;
                    k--;
                }
            }
            return res;
        }

        static class Element {
            int val;
            int index;

            public Element(int index, int val) {
                this.index = index;
                this.val = val;
            }
        }
    }
}
