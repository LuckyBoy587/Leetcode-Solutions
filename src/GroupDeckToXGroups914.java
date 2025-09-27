import java.util.HashMap;

public class GroupDeckToXGroups914 {
    private static class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int card : deck) {
                countMap.merge(card, 1, Integer::sum);
            }

            int minFreq = countMap.get(deck[0]);
            for (int freq : countMap.values()) {
                int currGCD = GCD(minFreq, freq);
                if (currGCD == 1) {
                    return false;
                }

                minFreq = currGCD;
            }

            return minFreq > 1;
        }

        private int GCD(int a, int b) {
            if (b == 0) return a;
            return GCD(b, a % b);
        }
    }
}
