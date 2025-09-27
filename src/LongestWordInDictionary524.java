import java.util.Collections;
import java.util.List;

public class LongestWordInDictionary524 {
    public static void main(String[] args) {
        List<String> dictionary = List.of("word", "good", "best", "good");
        String s = "wordgoodgoodgoodbestword";
        System.out.println(new Solution().findLongestWord(s, dictionary));
    }

    private static class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String res = "";
            for (String word : dictionary) {
                if (isSubsequence(s, word)) {
                    if (word.length() > res.length()) res = word;
                    else if (word.length() == res.length() && word.compareTo(res) < 0) res = word;
                }
            }
            return res;
        }


        private boolean isSubsequence(String w1, String w2) {
            int j = 0;
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) == w2.charAt(j)) j++;
                if (j == w2.length()) return true;
            }
            return false;
        }
    }
}
