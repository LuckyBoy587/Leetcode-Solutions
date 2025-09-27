public class LargestStringInBox3403 {
    private static class Solution {
        public String answerString(String word, int numFriends) {
            int subLength = word.length() - numFriends + 1;
            String res = "";
            for (int start = 0; start <= word.length(); start++) {
                for (int len = 1; len <= Math.min(subLength, word.length() - start); len++) {
                    String sub = word.substring(start, start + len);
                    if (sub.compareTo(res) > 0) {
                        res = sub;
                    }
                }
            }
            return res;
        }
    }
}
