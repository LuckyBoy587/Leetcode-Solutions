import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII2901 {
    public static void main(String[] args) {
        String[] words = {"bad", "dc", "bc", "ccd", "dd", "da", "cad", "dba", "aba"};
        int[] groups = {9, 7, 1, 2, 6, 8, 3, 7, 2};
        System.out.println(new Solution().getWordsInLongestSubsequence(words, groups));
    }

    private static class Solution {
        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
            int[] groupLength = new int[words.length];
            Arrays.fill(groupLength, 1);
            int[] prev = new int[words.length];
            int maxIndex = 0;
            Arrays.fill(prev, -1);
            for (int i = words.length - 1; i >= 0; i--) {
                for (int j = i + 1; j < words.length; j++) {
                    if (groups[i] != groups[j] && hasOneHammingDistance(words[i], words[j]) && groupLength[j] + 1 > groupLength[i]) {
                        groupLength[i] = groupLength[j] + 1;
                        prev[i] = j;

                        if (groupLength[i] > groupLength[maxIndex]) {
                            maxIndex = i;
                        }
                    }
                }
            }

            List<String> result = new ArrayList<>();
            result.add(words[maxIndex]);

            while (prev[maxIndex] != -1) {
                maxIndex = prev[maxIndex];
                result.add(words[maxIndex]);
            }

            return result;
        }

        private boolean hasOneHammingDistance(String word1, String word2) {
            if (word1.length() != word2.length()) return false;
            boolean result = false;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    if (result) return false;
                    result = true;
                }
            }

            return result;
        }
    }
}
