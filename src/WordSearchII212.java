import java.util.ArrayList;
import java.util.List;

public class WordSearchII212 {
    private static class Solution {
        List<String> res = new ArrayList<>();
        int m, n;
        String[] wordArr;

        static class Trie {
            Trie[] children = new Trie[26];
            boolean isWordEnd = false;
            int index = -1;
        }

        public List<String> findWords(char[][] board, String[] words) {
            Trie root = new Trie();
            for (int i = 0; i < words.length; i++) {
                insert(root, words[i], i);
            }
            m = board.length;
            n = board[0].length;
            wordArr = words;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    search(board, root, i, j);
                }
            }
            return res;
        }

        private void search(char[][] arr, Trie root, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || arr[i][j] == ' ') return;
            Trie currNode = root.children[arr[i][j] - 'a'];
            if (currNode == null) return;
            if (currNode.isWordEnd) {
                res.add(wordArr[currNode.index]);
            }
            char temp = arr[i][j];
            arr[i][j] = ' ';
            search(arr, currNode, i, j + 1);
            search(arr, currNode, i, j - 1);
            search(arr, currNode, i + 1, j);
            search(arr, currNode, i - 1, j);
            arr[i][j] = temp;
        }

        private void insert(Trie root, String word, int index) {
            Trie curr = root;
            for (char letter : word.toCharArray()) {
                if (curr.children[letter - 'a'] == null) {
                    curr.children[letter - 'a'] = new Trie();
                }
                curr = curr.children[letter - 'a'];
            }
            curr.isWordEnd = true;
            curr.index = index;
        }
    }
}
