import java.util.StringTokenizer;

public class GoatLatin824 {
    public static void main(String[] args) {
        System.out.println(new Solution().toGoatLatin("I speak Goat Latin"));
    }
    private static class Solution {
        public String toGoatLatin(String sentence) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(sentence);
            for (int i = 1; st.hasMoreTokens(); i++) {
                String word = st.nextToken();
                if (i != 1) sb.append(' ');
                if (isVowel(word.charAt(0))) {
                    sb.append(word);
                } else {
                    sb.append(word.substring(1)).append(word.charAt(0));
                }
                sb.append("ma").append("a".repeat(i));
            }
            return sb.toString();
        }

        private boolean isVowel(char letter) {
            return switch (Character.toLowerCase(letter)) {
                case 'a', 'e', 'i', 'o', 'u' -> true;
                default -> false;
            };
        }
    }
}
