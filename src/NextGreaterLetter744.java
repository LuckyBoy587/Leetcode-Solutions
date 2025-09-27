public class NextGreaterLetter744 {
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'i'));
    }

    private static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            for (char letter : letters) {
                if (letter > target) {
                    return letter;
                }
            }
            return letters[0];
        }
    }
}
