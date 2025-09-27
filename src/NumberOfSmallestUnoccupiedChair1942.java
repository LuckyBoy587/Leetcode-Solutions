import java.util.PriorityQueue;

public class NumberOfSmallestUnoccupiedChair1942 {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestChair(new int[][]{{3, 10}, {1, 5}, {2, 6}}, 0));
    }

    private static class Interval implements Comparable<Interval>{
        int arrival;
        int leaving;
        boolean isTarget;

        public Interval(int arrival, int leaving, boolean isTarget) {
            this.arrival = arrival;
            this.leaving = leaving;
            this.isTarget = isTarget;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.arrival, o.arrival);
        }

        @Override
        public String toString() {
            return "[" + arrival + ", " + leaving + "]";
        }
    }

    private static class Solution {
        public int smallestChair(int[][] times, int targetFriend) {
            PriorityQueue<Interval> pq = new PriorityQueue<>();
            int[] occupiedRows = new int[times.length];
            for (int i = 0; i < times.length; i++) {
                pq.add(new Interval(times[i][0], times[i][1], i == targetFriend));
            }
            while (!pq.isEmpty()) {
                Interval curr = pq.poll();
                int i;
                for (i = 0; i < times.length; i++) {
                    if (occupiedRows[i] <= curr.arrival) {
                        occupiedRows[i] = curr.leaving;
                        break;
                    }
                }
                if (curr.isTarget) return i;
            }
            return -1;
        }
    }
}
