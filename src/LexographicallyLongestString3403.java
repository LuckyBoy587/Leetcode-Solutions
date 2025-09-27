public class LexographicallyLongestString3403 {
    private static class Solution {
        public String answerString(String word, int numFriends) {
            if (numFriends == 1) return word;
            char[] letters = word.toCharArray();
            int maxIndex = 0;
            for (int i = 1; i < letters.length; i++) {
                if (letters[i] > letters[maxIndex]) {
                    maxIndex = i;
                }
            }
            int subLen = word.length() - numFriends + 1;
            String res = word.substring(0, subLen);
            for (int i = 1; i < letters.length; i++) {
                if (letters[i] != letters[maxIndex]) continue;
                String curr = word.substring(i, Math.min(i + subLen, letters.length));
                if (curr.compareTo(res) > 0) {
                    res = curr;
                }
            }
            return res;
        }
    }
}
