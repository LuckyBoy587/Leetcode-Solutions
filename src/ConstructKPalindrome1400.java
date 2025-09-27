public class ConstructKPalindrome1400 {
    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("annabelle", 2));
    }
        private static class Solution {
            public boolean canConstruct(String s, int k) {
                boolean[] isAlone = new boolean[26];
                int pairCount = 0;

                for (char letter : s.toCharArray()) {
                    int index = letter - 'a';
                    isAlone[index] = !isAlone[index];

                    if (!isAlone[index]) {
                        pairCount++;
                    }
                }

                int aloneCount = s.length() - pairCount;

                System.out.println(aloneCount);
                System.out.println(pairCount);

                return aloneCount <= k && aloneCount + 2 * pairCount >= k;
            }
        }
}
