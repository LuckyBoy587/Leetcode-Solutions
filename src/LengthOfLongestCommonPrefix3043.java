import java.util.Arrays;

public class LengthOfLongestCommonPrefix3043 {
    private static class Trie {
        Trie[] children;
        public boolean isWordEnd;

        Trie() {
            children = new Trie[10];
            Arrays.fill(children, null);
            isWordEnd = false;
        }

        public void insert(String prefix, int index) {
            if (index == prefix.length()) {
                isWordEnd = true;
            } else {
                char letter = prefix.charAt(index);
                if (children[letter - '0'] == null) {
                    children[letter - '0'] = new Trie();
                }
                children[letter - '0'].insert(prefix, index + 1);
            }
        }

        public int getPrefixLength(String word, int index) {
            if (index == word.length()) return index;
            char letter = word.charAt(index);
            if (children[letter - '0'] == null) return index;
            return children[letter - '0'].getPrefixLength(word, index + 1);
        }
    }

    private static class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Trie root = new Trie();
            for (int num: arr1) {
                root.insert(String.valueOf(num), 0);
            }
            int maxLen = 0;
            for (int num: arr2) {
                maxLen = Math.max(maxLen, root.getPrefixLength(String.valueOf(num), 0));
            }

            return maxLen;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new int[]{100, 124, 1256}, new int[]{10, 125}));
    }
}
