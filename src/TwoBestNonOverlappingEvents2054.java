import java.util.Arrays;
import java.util.Comparator;

public class TwoBestNonOverlappingEvents2054 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(new Solution().maxTwoEvents(matrix));
    }
    private static class Solution {
        public int maxTwoEvents(int[][] events) {
            Arrays.sort(events, Comparator.comparingInt(n -> n[1]));
            int[] maxValues = new int[events.length];
            maxValues[0] = events[0][2];

            for (int i = 1; i < events.length; i++) {
                maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
            }

            int res = 0;
            for (int[] event : events) {
                int index = findLastIndex(events, event[0]);
                if (index == -1) {
                    res = Math.max(res, event[2]);
                } else {
                    res = Math.max(res, event[2] + maxValues[index]);
                }
            }
            return res;
        }

        private int findLastIndex(int[][] events, int startTime) {
            int left = 0, right = events.length - 1;
            int result = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] >= startTime) {
                    right = mid - 1;
                } else {
                    result = mid;
                    left = mid + 1;
                }
            }
            return result;
        }
    }
}
