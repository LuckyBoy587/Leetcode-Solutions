import java.util.PriorityQueue;

public class DivideIntervalsIntoMinimumNumberOfGroups2406 {
    public static void main(String[] args) {
        System.out.println(new Solution().minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
    }

    private static class Solution {
        public int minGroups(int[][] intervals) {
            PriorityQueue<Interval> queue = new PriorityQueue<>();
            PriorityQueue<Interval> nextQueue = new PriorityQueue<>();
            for (int[] interval : intervals) {
                queue.offer(new Interval(interval[0], interval[1]));
            }

            int res = 0;
            while (!queue.isEmpty()) {
                res++;
                int size = queue.size();
                Interval previous = new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE);
                while (size-- > 0) {
                    Interval curr = queue.poll();
                    if (curr.start > previous.end) previous = new Interval(curr);
                    else nextQueue.offer(curr);
                }
                queue.addAll(nextQueue);
            }

            return res;
        }
    }

    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval(Interval other) {
            this(other.start, other.end);
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
