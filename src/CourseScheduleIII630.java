import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII630 {
    private static class Solution {
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int currTime = 0;
            for (int[] course : courses) {
                if (currTime + course[0] <= course[1]) {
                    currTime += course[0];
                    pq.offer(course[0]);
                } else if (!pq.isEmpty() && pq.peek() > course[0]) {
                    currTime += course[0] - pq.poll();
                    pq.offer(course[0]);
                }
            }
            return pq.size();
        }
    }
}
