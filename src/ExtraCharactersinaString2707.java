import java.util.Arrays;
import java.util.HashSet;

public class ExtraCharactersinaString2707 {
    private static class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
            int[] dp = new int[s.length() + 1];
            dp[0] = 0;

            for (int i = 1; i <= s.length(); i++) {
                dp[i] = dp[i - 1] + 1 ;
                for (int j = 0; j < i; j++) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = Math.min(dp[j], dp[i]);
                    }
                }
            }

            return dp[dp.length - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
    }
}
