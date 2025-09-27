import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class aaaInsertIntervals57 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{0, 0})));
    }
    private static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            Interval targetInterval = new Interval(newInterval);
            List<Interval> intervalList = new ArrayList<>();
            int i = 0;
            while (i < intervals.length && targetInterval.greaterThan(new Interval(intervals[i]))  && !targetInterval.overlappingWith(new Interval(intervals[i]))) {
                intervalList.add(new Interval(intervals[i++]));
            }

            int mergeCount = 0;
            while (i < intervals.length && targetInterval.overlappingWith(new Interval(intervals[i]))) {
                targetInterval.mergeWith(new Interval(intervals[i++]));
                mergeCount++;
            }

            int[][] res = new int[intervals.length - mergeCount + 1][];
            int index = 0;
            for (Interval interval: intervalList) {
                res[index++] = interval.toIntArray();
            }
            res[index++] = targetInterval.toIntArray();
            for (; i < intervals.length; i++) res[index++] = intervals[i];
            return res;
        }
    }

    static class Interval {
        int start;
        int end;

        private Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval(int[] interval) {
            this(interval[0], interval[1]);
        }

        public boolean greaterThan(Interval other) {
            return this.start > other.end;
        }

        public boolean overlappingWith(Interval other) {
            return Integer.max(start, other.start) <= Integer.min(end, other.end);
        }

        public void mergeWith(Interval other) {
            this.start = Integer.min(start, other.start);
            this.end = Integer.max(end, other.end);
        }

        public int[] toIntArray() {
            return new int[]{start, end};
        }
    }
}
