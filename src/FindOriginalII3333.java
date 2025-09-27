import java.util.ArrayList;
import java.util.List;

public class FindOriginalII3333 {
    public static void main(String[] args) {
        System.out.println(new Solution().possibleStringCount("alapsogbknzcdpwixijabqeieiszvvyvwshwzrzttfnupgxihk", 50));
    }

    private static class Solution {
        static final int MOD = 1_000_000_007;

        public int possibleStringCount(String word, int k) {
            List<Integer> groupLengths = new ArrayList<>();
            // Step 1: Get group lengths (run-length encoding)
            int cnt = 1;
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) == word.charAt(i - 1)) {
                    cnt++;
                } else {
                    groupLengths.add(cnt);
                    cnt = 1;
                }
            }
            groupLengths.add(cnt);
            int g = groupLengths.size();
            int n = groupLengths.size();
            int sum = 0;
            for (int len : groupLengths) sum += len;

            // If k > sum, impossible
            if (k > sum)
                return 0;
            // If the compressed string has length k and uses all characters, only 1 way
            if (k == n && sum == k) return 1;
            // Step 2: Calculate total possible strings (product of group lengths)
            long total = 1;
            for (int len : groupLengths) {
                total = (total * len) % MOD;
            }
            // Step 3: Subtract those with length < k using inclusion-exclusion
            // Precompute factorials and inverse factorials for combinations
            int maxLen = 0;
            for (int len : groupLengths) maxLen += len;
            int[] fact = new int[maxLen + 1];
            int[] invFact = new int[maxLen + 1];
            fact[0] = 1;
            for (int i = 1; i <= maxLen; i++) fact[i] = (int) ((long) fact[i - 1] * i % MOD);
            invFact[maxLen] = modInv(fact[maxLen]);
            for (int i = maxLen - 1; i >= 0; i--) invFact[i] = (int) ((long) invFact[i + 1] * (i + 1) % MOD);

            long lessThanK = 0;
            for (int length = g; length < k; length++) {
                lessThanK = (lessThanK + countWays(groupLengths, length, fact, invFact)) % MOD;
            }
            long ans = (total - lessThanK + MOD) % MOD;
            return (int) ans;
        }

        // Inclusion-Exclusion: count the number of ways to assign positive integer x_i ≤ group[i]
        // such that sum(x_i) = length, for all i
        private long countWays(List<Integer> groups, int length, int[] fact, int[] invFact) {
            int n = groups.size();
            int m = length - n; // total extra to distribute (all groups must be at least 1)
            long res = 0;
            for (int mask = 0; mask < (1 << n); mask++) {
                int sumBound = 0, bits = 0;
                for (int i = 0; i < n; i++) {
                    if (((mask >> i) & 1) != 0) {
                        sumBound += groups.get(i) - 1; // correct: exclude the minimum 1
                        bits++;
                    }
                }
                int rem = m - sumBound;
                long ways = rem < 0 ? 0 : nCk(rem + n - 1, n - 1, fact, invFact);
                if ((bits & 1) == 0) {
                    res = (res + ways) % MOD;
                } else {
                    res = (res - ways + MOD) % MOD;
                }
            }
            return res;
        }

        private int modInv(int x) {
            return pow(x, MOD - 2);
        }

        private int pow(int a, int b) {
            long res = 1, base = a;
            while (b > 0) {
                if ((b & 1) != 0) res = res * base % MOD;
                base = base * base % MOD;
                b >>= 1;
            }
            return (int) res;
        }

        private int nCk(int n, int k, int[] fact, int[] invFact) {
            if (k < 0 || k > n) return 0;
            return (int) ((long) fact[n] * invFact[k] % MOD * invFact[n - k] % MOD);
        }
    }
}
