import java.util.ArrayList;
import java.util.List;

public class WordSubsets916 {
    private static class Solution {
        int[] map = new int[26];

        public List<String> wordSubsets(String[] words1, String[] words2) {
            int[][] freq = getFrequencyArray(words1);
            for (String word : words2) {
                update(word);
            }

            List<String> res = new ArrayList<>();

            for (int i = 0; i < freq.length; i++) {
                boolean flag = true;
                for (int j = 0; j < 26; j++) {
                    if (freq[i][j] < map[j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    res.add(words1[i]);
                }
            }
            return res;
        }

        private void update(String word) {
            int[] freq = new int[26];
            for (char letter : word.toCharArray()) {
                freq[letter - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                map[i] = Math.max(map[i], freq[i]);
            }
        }

        private int[][] getFrequencyArray(String[] words) {
            int[][] freq = new int[words.length][26];
            for (int i = 0; i < words.length; i++) {
                int[] row = new int[26];
                for (char letter : words[i].toCharArray()) {
                    row[letter - 'a']++;
                }
                freq[i] = row;
            }
            return freq;
        }
    }
}
