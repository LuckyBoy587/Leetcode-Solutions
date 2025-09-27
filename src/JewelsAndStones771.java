public class JewelsAndStones771 {
    private static class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            boolean[] smallJewels = new boolean[26];
            boolean[] capiatlJewels = new boolean[26];

            for (char letter : jewels.toCharArray()) {
                if (letter >= 'a') smallJewels[letter - 'a'] = true;
                else capiatlJewels[letter - 'A'] = true;
            }

            int res = 0;
            for (char letter : stones.toCharArray()) {
                if (letter >= 'a') res += smallJewels[letter - 'a'] ? 1 : 0;
                else res += capiatlJewels[letter - 'A'] ? 1 : 0;
            }

            return res;
        }
    }
}
