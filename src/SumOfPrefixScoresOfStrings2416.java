import java.util.Arrays;

public class SumOfPrefixScoresOfStrings2416 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumPrefixScores(new String[]{"abc","ab","bc","b"})));
    }
    private static class Trie {
        Trie[] children;
        int count = 0;

        Trie() {
            children = new Trie[26];
            for (int i = 0; i < 26; i++) children[i] = null;
        }

        public void insert(String word) {
            Trie curr = this;
            for (char letter: word.toCharArray()) {
                int index = letter - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Trie();
                }

                curr.children[index].count++;
                curr = curr.children[index];
            }
        }

        public int getWordSum(String word) {
            int res = 0;
            Trie curr = this;
            for (char letter: word.toCharArray()) {
                int index = letter - 'a';
                curr = curr.children[index];
                res += curr.count;
            }

            return res;
        }
    }

    private static class Solution {
        public int[] sumPrefixScores(String[] words) {
            Trie root = new Trie();
            for (String word: words) {
                root.insert(word);
            }

            int[] resArr = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                resArr[i] = root.getWordSum(words[i]);
            }

            return resArr;
        }
    }
}
