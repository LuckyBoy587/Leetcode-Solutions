import java.util.HashSet;

public class ConsecutiveNumberSum829 {
    private static class Solution {
        public int consecutiveNumbersSum(int n) {
            long currSum = 0;
            int count = 0;
            HashSet<Long> seenSums = new HashSet<>();
            seenSums.add(0L);

            for (int i = 1; currSum <= n; i++) {
                currSum += i;
                if (seenSums.contains(n - currSum)) {
                    count++;
                }
                seenSums.add(currSum);
            }
            return count;
        }
    }
}
