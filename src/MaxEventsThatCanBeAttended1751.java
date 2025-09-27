import java.util.Arrays;

public class MaxEventsThatCanBeAttended1751 {
    private static class Solution {
        Integer[][] memo;
        public int maxValue(int[][] events, int k) {
            Event[] sortedEvents = new Event[events.length];
            for (int i = 0; i < events.length; i++) {
                sortedEvents[i] = new Event(events[i][0], events[i][1], events[i][2]);
            }
            Arrays.sort(sortedEvents, (a, b) -> {
                if (a.start != b.start) return a.start - b.start;
                return b.value - a.value;
            });
            memo = new Integer[k + 1][events.length];
            return dfs(sortedEvents, k, 0);
        }

        private int dfs(Event[] events, int remAttend, int eventIndex) {
            if (remAttend == 0 || eventIndex == events.length) return 0;
            if (memo[remAttend][eventIndex] != null) return memo[remAttend][eventIndex];
            int pick = events[eventIndex].value + dfs(events, remAttend - 1, chooseNextIndex(events, eventIndex + 1, events[eventIndex].end));
            int skip = dfs(events, remAttend, eventIndex + 1);
            return memo[remAttend][eventIndex] = Math.max(pick, skip);
        }

        private int chooseNextIndex(Event[] events, int start, int target) {
            int left = start, right = events.length - 1;
            int res = events.length;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid].start > target) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return res;
        }

        static class Event {
            int start, end, value;
            public Event(int start, int end, int value) {
                this.start = start;
                this.end = end;
                this.value = value;
            }
        }
    }
}
