import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        System.out.println(new Solution().partition("apple"));
    }

    private static class Solution {
        public List<List<String>> partition(String s) {
            List<List<List<String>>> dp = new ArrayList<>();
            for (int i = 0; i <= s.length(); i++) dp.add(new ArrayList<>());
            dp.getFirst().add(new ArrayList<>());
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String sub = s.substring(j, i);
                    if (isPalindrome(sub)) {
                        List<List<String>> currRow = dp.get(i);
                        for (List<String> possibles: dp.get(j)) {
                            List<String> partition = new ArrayList<>(possibles);
                            partition.add(sub);
                            currRow.add(partition);
                        }
                    }
                }
            }
//            System.out.println(dp);
            return dp.get(s.length());
        }

        private boolean isPalindrome(String word) {
            int i = 0, j = word.length() - 1;
            while (i < j) {
                if (word.charAt(i) != word.charAt(j)) return false;
                i++;
                j--;
            }

            return true;
        }
    }
}
