public class NumberOfMatchingSubsequence792 {
    public static void main(String[] args) {
        System.out.println(new Solution().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace", "a"}));
    }

    private static class Solution {
        int res = 0;

        public int numMatchingSubseq(String s, String[] words) {
            TrieNode root = new TrieNode('?');
            for (String word : words) {
                addWord(root, word, 0);
            }

            get(s, 0, root);
            return res;
        }

        private void get(String s, int index, TrieNode root) {
            if (root.isEnd) {
                res += root.repetitionCount;
            }
            for (TrieNode child : root.children) {
                if (child != null) {
                    int nextIndex = s.indexOf(child.val, index);
                    if (nextIndex != -1) {
                        get(s, nextIndex + 1, child);
                    }
                }
            }
        }

        private void addWord(TrieNode root, String word, int index) {
            if (index == word.length()) {
                root.isEnd = true;
                root.repetitionCount++;
            } else {
                int letterIndex = word.charAt(index) - 'a';
                if (root.children[letterIndex] == null) {
                    root.children[letterIndex] = new TrieNode(word.charAt(index));
                }
                addWord(root.children[letterIndex], word, index + 1);
            }
        }

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
            char val;
            int repetitionCount = 0;

            public TrieNode(char val) {
                this.val = val;
            }
        }
    }
}
