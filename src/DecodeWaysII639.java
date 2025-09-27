import java.util.HashMap;

public class DecodeWaysII639 {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("********"));
    }

    private static class Solution {
        private final int MOD = 1000000007;
        Integer[] memo;
        HashMap<String, Long> bigMemo;

        public int numDecodings(String s) {
            bigMemo = new HashMap<>();
            return (int) find(s, 0, new StringBuilder()) % MOD;
        }

        private long find(String s, int index, StringBuilder curr) {
            if (index == s.length()) {
                memo = new Integer[curr.length()];
                return decode(curr.toString().toCharArray(), 0);
            }
            String key = index + "-" + curr.toString();
            if (bigMemo.containsKey(key)) return bigMemo.get(key);
            long res = 0;
            char letter = s.charAt(index);
            if (letter == '*') {
                for (char c = '1'; c <= '9'; c++) {
                    curr.append(c);
                    res = res + find(s, index + 1, curr) % MOD;
                    curr.deleteCharAt(curr.length() - 1);
                }
            } else {
                curr.append(letter);
                res = res + find(s, index + 1, curr) % MOD;
                curr.deleteCharAt(curr.length() - 1);
            }
            bigMemo.put(key, res % MOD);
            return res % MOD;
        }

        private int decode(char[] arr, int index) {
            if (index == arr.length) return 1;
            if (memo[index] != null) return memo[index];
            int curr = 0, count = 0;
            for (int i = index; i < arr.length; i++) {
                curr = curr * 10 + arr[i] - '0';
                if (isNotInRange(curr)) break;
                count += decode(arr, i + 1);
            }

            return memo[index] = count;
        }

        private boolean isNotInRange(int curr) {
            return curr < 1 || 26 < curr;
        }
    }
}
