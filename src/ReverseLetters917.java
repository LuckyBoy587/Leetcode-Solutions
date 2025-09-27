public class ReverseLetters917 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    private static class Solution {
        public String reverseOnlyLetters(String s) {
            char[] letters = s.toCharArray();
            int start = 0, end = letters.length - 1;

            while (start < end) {
                while (start < end && !Character.isLetter(letters[start])) start++;
                while (start < end && !Character.isLetter(letters[end])) end--;

                char temp = letters[start];
                letters[start] = letters[end];
                letters[end] = temp;
                start++;
                end--;
            }
            return new String(letters);
        }
    }
}
