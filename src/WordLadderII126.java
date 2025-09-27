import java.util.*;

public class WordLadderII126 {
    public static void main(String[] args) {
        String[] stringArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(stringArray);
        System.out.println(new Solution().findLadders("hit", "cog", wordList));
    }
    private static class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> wildcardGraph = new ArrayList<>();
            for (String currWord : wordList) {
                List<String> currWildcards = new ArrayList<>();
                for (int breakIndex = 0; breakIndex < currWord.length(); breakIndex++) {
                    currWildcards.add(currWord.substring(0, breakIndex) + currWord.substring(breakIndex + 1));
                }
                wildcardGraph.add(currWildcards);
            }

            return wildcardGraph;
        }
    }
}
