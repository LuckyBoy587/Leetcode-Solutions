import java.util.Objects;

public class SentenceSimilarityIII1813 {
    public static void main(String[] args) {
        System.out.println(new Solution().areSentencesSimilar("Eating right now", "Eating"));
    }
    private static class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            if (sentence1.length() < sentence2.length()) {
                return areSentencesSimilar(sentence2, sentence1);
            }
            String[] wordsOfLarge = sentence1.split(" ");
            String[] wordsOfSmall = sentence2.split(" ");

            int st = -1;
            while (st + 1 < wordsOfSmall.length && Objects.equals(wordsOfSmall[st + 1], wordsOfLarge[st + 1])) st++;
            int largeEnd = wordsOfLarge.length, smallEnd = wordsOfSmall.length;
            while (smallEnd > 0 && wordsOfSmall[smallEnd - 1].equals(wordsOfLarge[largeEnd - 1])) {
                smallEnd--;
                largeEnd--;
            }
            return st + 1 == smallEnd;
        }
    }
}
