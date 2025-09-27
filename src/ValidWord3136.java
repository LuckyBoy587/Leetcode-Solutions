public class ValidWord3136 {
    private static class Solution {
        public boolean isValid(String word) {
            if (word.length() < 3) return false;
            boolean hasVowel = false;
            boolean hasConsonant = false;

            for (char letter: word.toCharArray()) {
                if (Character.isLetter(letter)) {
                    letter = Character.toLowerCase(letter);
                    if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                        hasVowel = true;
                    } else {
                        hasConsonant = true;
                    }
                } else if (!Character.isDigit(letter)) {
                    return false;
                }
            }

            return hasVowel && hasConsonant;
        }
    }
}
