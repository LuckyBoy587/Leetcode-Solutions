import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO502 {
    private static class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            Integer[] indexes = new Integer[capital.length];
            for (int i = 0; i < capital.length; i++) {
                indexes[i] = i;
            }
            Arrays.sort(indexes, Comparator.comparingInt(i -> capital[i]));
            PriorityQueue<Integer> profitQueue = new PriorityQueue<>((p1, p2) -> p2 - p1);
            int projectIndex = 0;
            while (projectIndex < profits.length && capital[indexes[projectIndex]] <= w) {
                profitQueue.offer(profits[indexes[projectIndex]]);
                projectIndex++;
            }

            while (k-- > 0 && !profitQueue.isEmpty()) {
                Integer currProfit = profitQueue.poll();
                w += currProfit;

                while (projectIndex < profits.length && capital[indexes[projectIndex]] <= w) {
                    profitQueue.offer(profits[indexes[projectIndex]]);
                    projectIndex++;
                }
            }

            return w;
        }
    }
}
