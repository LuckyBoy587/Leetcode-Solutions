public class TotalCharactersInStringAfterTransformationI3335 {
    private static class Solution {
        int MOD = 1000000007;
        Integer[][] dp;
        public int lengthAfterTransformations(String s, int t) {
            dp = new Integer[26][t + 1];
            long res = 0;
            for (char letter : s.toCharArray()) {
                res = (res + len(letter, t)) % MOD;
            }

            return (int) res;
        }

        public int len(char letter, int t) {
            if (dp[letter - 'a'][t] != null) return dp[letter - 'a'][t];
            int distance = 'z' - letter;
            if (t < distance) return 1;
            return dp[letter - 'a'][t] = len('a', t - distance) + len('b', t - distance) % MOD;
        }
    }
}
