import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference539 {
    private static class Solution {
        public int findMinDifference(List<String> timePoints) {
            Time[] times = new Time[timePoints.size()];
            for (int i = 0; i < timePoints.size(); i++) {
                times[i] = new Time(timePoints.get(i));
            }
            Arrays.sort(times, Comparator.comparingInt(t -> t.minutes));

            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < times.length; i++) {
                minDiff = Math.min(minDiff, Time.getDifference(times[i - 1], times[i]));
            }

            int wrapAroundDiff = Time.getTotalMinutes(times[0], times[times.length - 1]);
            minDiff = Math.min(minDiff, Math.min(wrapAroundDiff, Time.MINUTES_PER_DAY - wrapAroundDiff));
            return minDiff;
        }

        static class Time {
            int minutes;
            public static final int MINUTES_PER_DAY = 24 * 60 * 60;
            public Time(String time) {
                String[] parts = time.split(":");
                int hours = Integer.parseInt(parts[0]);
                minutes = Integer.parseInt(parts[1]);
                minutes += hours * 60;
            }

            public static int getDifference(Time start, Time end) {
                return Math.abs(end.minutes - start.minutes);
            }

            public static int getTotalMinutes(Time t1, Time t2) {
                return t1.minutes + t2.minutes;
            }
        }
    }
}
