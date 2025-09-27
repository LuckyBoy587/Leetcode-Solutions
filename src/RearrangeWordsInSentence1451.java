import java.util.Arrays;
import java.util.Comparator;

public class RearrangeWordsInSentence1451 {
    public static void main(String[] args) {
        System.out.println(new Solution().arrangeWords("Keep calm and code on"));
    }
    private static class Solution {
        public String arrangeWords(String text) {
            String[] words = text.split(" ");
            char[] firstWord = words[0].toCharArray();
            firstWord[0] = Character.toLowerCase(firstWord[0]);
            words[0] = new String(firstWord);

            Arrays.sort(words, Comparator.comparingInt(String::length));
            StringBuilder sb = new StringBuilder();
            sb.append(words[0]);
            for (int i = 1; i < words.length; i++) {
                sb.append(' ').append(words[i]);
            }
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return sb.toString();
        }
    }
}
