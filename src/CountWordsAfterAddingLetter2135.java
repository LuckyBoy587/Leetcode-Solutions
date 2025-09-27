import java.util.HashSet;

public class CountWordsAfterAddingLetter2135 {
    public static void main(String[] args) {
        String[] arr1 = {"akt","act","tack"};
        String[] arr2 = {"tack","act","acti"};

        System.out.println(new Solution().wordCount(arr1, arr2));
    }

    private static class Solution {
        public int wordCount(String[] startWords, String[] targetWords) {
            HashSet<Integer> bitset = new HashSet<>();
            for (String word : startWords) {
                bitset.add(toBits(word));
            }

            int count = 0;
            for (String word : targetWords) {
                int currBinaryWord = toBits(word);
                for (int pos = 0; pos < 26; pos++) {
                    int startCheck = currBinaryWord ^ (1 << pos);
                    if (startCheck < currBinaryWord && bitset.contains(startCheck)) {
                        count++;
                        break;
                    }
                }
            }

            return count;
        }

        private int toBits(String word) {
            int res = 0;
            for (char letter : word.toCharArray()) {
                res |= (1 << letter - 'a');
            }
            return res;
        }
    }
}
