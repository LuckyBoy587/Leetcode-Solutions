public class LongestBinarySubsequenceLessThanK2311 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubsequence("000101010011011001011101111000111111100001011000000100010000111100000011111001000111100111101001111001011101001011011101001011011001111111010011100011110111010000010000010111001001111101100001111", 300429827));
    }

    private static class Solution {
        public int longestSubsequence(String s, int k) {
            int curr = 0;
            int count = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int digit = s.charAt(i) - '0';
                if (digit == 1 && curr <= k) {
                    int pos = s.length() - i - 1;
                    if (pos < 31) {
                        curr |= (1 << pos);
                    } else {
                        curr = Integer.MAX_VALUE;
                    }
                }
                if (curr <= k || digit == 0) {
                    count++;
                }
            }

            return count;
        }
    }
}
