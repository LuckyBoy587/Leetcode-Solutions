public class DecodeWays91 {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("11111111111111111111111111111111111"));
        System.out.println(14930352);
    }

    private static class Solution {
        Integer[] memo;

        public int numDecodings(String s) {
            memo = new Integer[s.length()];
            return decode(s.toCharArray(), 0);
        }

        private int decode(char[] arr, int index) {
            if (index == arr.length) return 1;
            if (memo[index] != null) return memo[index];
            int curr = 0, count = 0;
            for (int i = index; i < arr.length; i++) {
                curr = curr * 10 + arr[i] - '0';
                if (!isInRange(curr)) break;
                count += decode(arr, i + 1);
            }

            return memo[index] = count;
        }

        private boolean isInRange(int curr) {
            return 1 <= curr && curr <= 26;
        }
    }
}
