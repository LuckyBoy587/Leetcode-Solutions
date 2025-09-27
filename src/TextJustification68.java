import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {
    public static void main(String[] args) {
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth = 20;
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }

    private static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int[] lengthSoFar = new int[words.length + 1];
            lengthSoFar[0] = words[0].length();
            for (int i = 1; i < words.length; i++) {
                lengthSoFar[i] = lengthSoFar[i - 1] + words[i].length();
            }
            List<String> res = new ArrayList<>();
            int left = 0, right = 0;
            int prevLength = 0;
            while (right < words.length) {
                while (right < words.length && lengthSoFar[right] - prevLength + right - left <= maxWidth) {
                    right++;
                }

                if (right == words.length) break;

                int currWidth = lengthSoFar[right - 1] - prevLength;
                int emptySpace = Math.max(0, maxWidth - currWidth);
                int numWords = right - left;

                StringBuilder sb = new StringBuilder();
                if (numWords == 1) {
                    sb.append(words[left]).append(" ".repeat(emptySpace));
                } else {
                    int spacePerGap = emptySpace / (numWords - 1);
                    int extraSpace = emptySpace % (numWords - 1);
                    for (int i = left; i < right; i++) {
                        if (i > left) {
                            String space = " ".repeat(spacePerGap + (extraSpace-- > 0 ? 1 : 0));
                            sb.append(space);
                        }
                        sb.append(words[i]);
                    }
                }
                prevLength = lengthSoFar[right - 1];
                left = right;
                res.add(sb.toString());
            }

            StringBuilder lastLine = new StringBuilder();
            for (int i = left; i < words.length; i++) {
                if (i > left) lastLine.append(" ");
                lastLine.append(words[i]);
            }
            lastLine.append(" ".repeat(maxWidth - lastLine.length()));
            res.add(lastLine.toString());
            return res;
        }
    }
}
