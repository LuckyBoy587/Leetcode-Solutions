public class AddAndSearchWords211 {
    private static class WordDictionary {
        TrieNode root = new TrieNode();
        public WordDictionary() {

        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }

            curr.isEnd = true;
        }

        public boolean search(String word) {
            return search(root, word, 0);
        }

        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            public boolean isEnd = false;
        }

        private boolean search(TrieNode root, String word, int index) {
            if (index == word.length()) {
                return root.isEnd;
            }

            char letter = word.charAt(index);
            if (letter == '.') {
                for (TrieNode child : root.children) {
                    if (child != null && search(child, word, index + 1)) {
                        return true;
                    }
                }

                return false;
            } else {
                TrieNode child = root.children[letter - 'a'];
                return child != null && search(child, word, index + 1);
            }
        }
    }
}
