/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

- WordDictionary() Initializes the object.
- void addWord(word) Adds word to the data structure, it can be matched later.
- bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],[ "bad" ],[ "dad" ],[ "mad" ],[ "pad" ],[ "bad" ],[ ".ad" ],[ "b.." ]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

Constraints:

- 1 <= word.length <= 25
- word in addWord consists of lowercase English letters.
- word in search consist of '.' or lowercase English letters.
- There will be at most 2 dots in word for search queries.
- At most 10^4 calls will be made to addWord and search.
*/

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

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        // Test cases
        boolean[] expected = {false, true, true, true};
        String[] searches = {"pad", "bad", ".ad", "b.."};
        boolean[] results = new boolean[4];

        for (int i = 0; i < searches.length; i++) {
            results[i] = wordDictionary.search(searches[i]);
            if (results[i] == expected[i]) {
                System.out.println("Test " + (i+1) + " passed: search(\"" + searches[i] + "\") = " + results[i]);
            } else {
                System.out.println("Test " + (i+1) + " failed: search(\"" + searches[i] + "\") = " + results[i] + ", expected " + expected[i]);
            }
        }
    }
}
