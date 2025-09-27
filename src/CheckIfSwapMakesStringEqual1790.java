import java.util.Arrays;

public class CheckIfSwapMakesStringEqual1790 {
    private static class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            if (!Arrays.equals(c1, c2)) return false;
            int diffCount = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCount++;
                }
            }
            return diffCount == 0 || diffCount == 2;
        }
    }
}
