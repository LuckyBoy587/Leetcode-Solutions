public class CircularSentence2490 {
    public static void main(String[] args) {
        System.out.println(new Solution().isCircularSentence("leetcode exercises sound delightful"));
    }

    private static class Solution {
        public boolean isCircularSentence(String sentence) {
            if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
                return false;
            }

            int spaceIndex = sentence.indexOf(' ');
            while (spaceIndex != -1) {
                if (sentence.charAt(spaceIndex - 1) != sentence.charAt(spaceIndex + 1)) {
                    return false;
                }

                spaceIndex = sentence.indexOf(' ', spaceIndex + 1);
            }

            return true;
        }
    }
}
