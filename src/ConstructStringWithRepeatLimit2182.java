public class ConstructStringWithRepeatLimit2182 {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatLimitedString("aababab", 2));
    }

    private static class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (char currLetter = 'z'; currLetter >= 'a'; currLetter--) {
                char nextLetter = (char) (currLetter - 1);
                while (freq[currLetter - 'a'] > 0) {
                    if (freq[currLetter - 'a'] > repeatLimit) {
                        int repeatCount = repeatLimit;
                        freq[currLetter - 'a'] -= repeatCount;
                        while (repeatCount-- > 0) {
                            sb.append(currLetter);
                        }
                        while (nextLetter >= 'a' && freq[nextLetter - 'a'] == 0) {
                            nextLetter--;
                        }
                        if (nextLetter < 'a') return sb.toString();
                        sb.append(nextLetter);
                        freq[nextLetter - 'a']--;
                    } else {
                        int repeatCount = freq[currLetter - 'a'];
                        freq[currLetter - 'a'] = 0;
                        while (repeatCount-- > 0) {
                            sb.append(currLetter);
                        }
                    }
                }
            }
            return sb.toString();

        }
    }
}
