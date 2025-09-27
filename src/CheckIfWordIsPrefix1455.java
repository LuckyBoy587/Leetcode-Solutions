import java.util.StringTokenizer;

public class CheckIfWordIsPrefix1455 {
    private static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            StringTokenizer st = new StringTokenizer(sentence);
            for (int i = 1; st.hasMoreTokens(); i++) {
                String word = st.nextToken();
                if (word.startsWith(searchWord)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
