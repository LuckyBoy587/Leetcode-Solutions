import java.util.HashSet;
import java.util.Set;

public class MaximumWordsYouCanType1935 {
    private static class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {
            Set<Character> broken = new HashSet<>();
            for (char letter : brokenLetters.toCharArray()) {
                broken.add(letter);
            }
            return count(text.split(" "), 0, broken);
        }

        private int count(String[] words, int index, Set<Character> broken) {
            if (index == words.length) {
                return 0;
            }
            for (char letter : words[index].toCharArray()) {
                if (broken.contains(letter)) {
                    return count(words, index + 1, broken);
                }
            }

            return 1 + count(words, index + 1, broken);
        }
    }
}
