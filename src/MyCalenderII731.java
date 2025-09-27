import java.util.*;

public class MyCalenderII731 {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class MyCalendarTwo {
        List<Interval> booked, overlapped;

        public MyCalendarTwo() {
            booked = new ArrayList<>();
            overlapped = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            Interval curr = new Interval(start, end);
            for (Interval interval : overlapped) {
                if (isOverlapped(interval, curr)) {
                    return false;
                }
            }

            for (Interval interval : booked) {
                if (isOverlapped(interval, curr)) {
                    overlapped.add(getOverlapped(interval, curr));
                }
            }

            booked.add(curr);
            return true;
        }

        public boolean isOverlapped(Interval i1, Interval i2) {
            return Integer.max(i1.start, i2.start) < Integer.min(i1.end, i2.end);
        }

        public Interval getOverlapped(Interval i1, Interval i2) {
            return new Interval(Integer.max(i1.start, i2.start), Integer.min(i1.end, i2.end));
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();

        // Input data
        int[][] bookParams = {
                {33, 44}, {85, 95}, {20, 37}, {91, 100}, {89, 100}, {77, 87}, {80, 95}, {42, 61}, {40, 50}, {85, 99},
                {74, 91}, {70, 82}, {5, 17}, {77, 89}, {16, 26}, {21, 31}, {30, 43}, {96, 100}, {27, 39}, {44, 55}, {15, 34},
                {85, 99}, {74, 93}, {84, 94}, {82, 94}, {46, 65}, {31, 49}, {58, 73}, {86, 99}, {73, 84}, {68, 80}, {5, 18},
                {75, 87}, {88, 100}, {25, 41}, {66, 79}, {28, 41}, {60, 70}, {62, 73}, {16, 33}
        };

        // Process commands
        boolean[] results = new boolean[bookParams.length];
        for (int i = 0; i < bookParams.length; i++) {
            results[i] = calendar.book(bookParams[i][0], bookParams[i][1]);
        }

        // Print results
        System.out.println(Arrays.toString(results));
    }
}