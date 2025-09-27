public class AddingSpaceToString2109 {
    private static class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            char[] letters = s.toCharArray();

            for (int i = 0; i < letters.length; i++) {
                if (j < spaces.length && i == spaces[j]) {
                    sb.append(' ');
                    ++j;
                }
                sb.append(letters[i]);
            }
            return sb.toString();
        }
    }
}
