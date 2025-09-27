import java.util.*;

public class WordLadder127 {
    private static class Solution {
        static class Node {
            String word;
            int count;

            public Node(String word, int count) {
                this.word = word;
                this.count = count;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(beginWord, 1));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                char[] wordArray = node.word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    for (int charValue = 0; charValue < 26; charValue++) {
                        char currLetter = (char) (charValue + 'a');
                        if (wordArray[i] == currLetter) continue;
                        char temp = wordArray[i];
                        wordArray[i] = currLetter;
                        String newWord = new String(wordArray);
                        if (wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            if (newWord.equals(endWord)) {
                                return node.count + 1;
                            }
                            queue.offer(new Node(newWord, node.count + 1));
                        }
                        wordArray[i] = temp;
                    }
                }
            }

            return 0;
        }
    }
}
