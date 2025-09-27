public class MovePices2337 {
    private static class Solution {
        public boolean canChange(String start, String target) {
            int i = 0, j = 0;
            int n = start.length();
            char[] startWord = start.toCharArray();
            char[] targetWord = target.toCharArray();

            while (i < n && j < n) {
                while (i < n && startWord[i] == '_') ++i;
                while (j < n && targetWord[i] == '_') ++j;

                if (i < n && j < n) {
                    if (startWord[i] != targetWord[j]) return false;
                    if (startWord[i] == 'L' && i < j) return false;
                    if (startWord[i] == 'R' && i > j) return false;

                    i++;
                    j++;
                } else if (i < n && j == n) return false;
                else if (i == n && j < n) return false;
            }

            return i == n && j == n;
        }
    }
}
