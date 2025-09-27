public class RescheduleMeeting3439 {
    public static void main(String[] args) {
        int eventTime = 96;
        int k = 3;
        int[] startTime = {4, 11, 16, 53};
        int[] endTime = {11, 16, 27, 77};

        Solution solution = new Solution();
        int result = solution.maxFreeTime(eventTime, k, startTime, endTime);
        System.out.println("Maximum free time: " + result);
    }

    private static class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            int currDuration = 0, maxGap = startTime[0];

            for (int i = 0; i < startTime.length; i++) {
                currDuration += endTime[i] - startTime[i];
                if (i >= k) {
                    int currWindowStart = i == k ? 0: endTime[i - k - 1];
                    int currGap = endTime[i] - currDuration - currWindowStart;
                    maxGap = Math.max(maxGap, currGap);
                    currDuration -= endTime[i - k] - startTime[i - k];
                }
            }

            int currWindowStart = k >= startTime.length ? 0: endTime[endTime.length - k - 1];
            maxGap = Math.max(maxGap, eventTime - currDuration - currWindowStart);
            return maxGap;
        }
    }
}
