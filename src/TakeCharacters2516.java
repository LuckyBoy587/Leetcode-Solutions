import java.util.Arrays;

public class TakeCharacters2516 {
    public static void main(String[] args) {
        System.out.println(new TakeCharacters2516.Solution().takeCharacters("abc", 0));
    }

    private static class Solution {
        public int takeCharacters(String s, int k) {
            if (k == 0) return 0;
            char[] letters = s.toCharArray();
            int[] freq = new int[3];
            for (char letter : letters) {
                freq[letter - 'a']++;
            }

            if (freq[0] < k || freq[1] < k || freq[2] < k) {
                return -1;
            }

            int res = 0;
            for (int left = 0; left <= letters.length - 3 * k; left++) {
                int[] windowCount = new int[26];
                int right = left;
                while (right < letters.length && (windowCount[0] < k || windowCount[1] < k || windowCount[2] < k)) {
                    windowCount[letters[right++] - 'a']--;
                }

                    res = Math.max(res, right - left - 1);
            }

            return letters.length - res;
        }
    }
}
