import java.util.Arrays;

public class MinimumTicketCost983 {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(new Solution().mincostTickets(days, costs));
    }

    private static class Solution {
        int[] dp;

        public int mincostTickets(int[] days, int[] costs) {
            dp = new int[days.length];
            Arrays.fill(dp, -1);
            return find(days, costs, 0);
        }

        private int find(int[] days, int[] costs, int index) {
            if (index == days.length) {
                return 0;
            }

            if (dp[index] != -1) {
                return dp[index];
            }

            int oneDay = find(days, costs,getNextIndex(days, index, days[index] + 1)) + costs[0];
            int sevenDay = find(days, costs,getNextIndex(days, index, days[index] + 7)) + costs[1];
            int thirtyDay = find(days, costs,getNextIndex(days, index, days[index] + 30)) + costs[2];

            dp[index] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
            return dp[index];
        }

        private int getNextIndex(int[] days, int currentIndex, int limit) {
            while (currentIndex < days.length && days[currentIndex] < limit) {
                currentIndex++;
            }
            return currentIndex;
        }
    }
}
