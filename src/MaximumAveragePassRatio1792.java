import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio1792 {
    public static void main(String[] args) {
        int[][] myArray = {{1, 2}, {3, 5}, {2, 2}};
        System.out.println(new Solution().maxAverageRatio(myArray, 2));
    }
    private static class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> Double.compare(changeInPassRatio(arr2) , changeInPassRatio(arr1)));
            for (int[] row : classes) {
                pq.offer(row);
            }

            while (extraStudents-- > 0 && !pq.isEmpty()) {
                int[] curr = pq.poll();
//                System.out.println(Arrays.toString(curr));
                ++curr[0];
                ++curr[1];
                pq.offer(curr);
            }

            double res = 0;
            for (int[] row : classes) {
                res += passRatio(row);
            }
//            System.out.println(Arrays.deepToString(classes));
            return res / classes.length;
        }

        private double passRatio(int[] row) {
            return (double) row[0] / row[1];
        }

        private double changeInPassRatio(int[] row) {
            return ((double) (row[0] + 1) / (row[1] + 1)) - passRatio(row);
        }
    }
}
