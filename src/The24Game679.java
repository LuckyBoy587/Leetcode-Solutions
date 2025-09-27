public class The24Game679 {
    public static void main(String[] args) {
        System.out.println(new Solution().judgePoint24(new int[]{1, 5, 9, 1}));
    }

    private static class Solution {
        public boolean judgePoint24(int[] cards) {
            double[] doubleCards = new double[cards.length];
            for (int i = 0; i < cards.length; i++) doubleCards[i] = cards[i];
            return dfs(doubleCards, cards.length);
        }

        private boolean dfs(double[] cards, int maxIndex) {
            if (maxIndex == 1) return Math.abs(cards[0] - 24) < 1e-6;
            for (int i = 0; i < maxIndex; i++) {
                double temp1 = cards[i];
                for (int j = i + 1; j < maxIndex; j++) {
                    double temp2 = cards[j];
                    cards[j] = cards[maxIndex - 1];

                    cards[i] = temp1 + temp2;
                    if (dfs(cards, maxIndex - 1)) return true;

                    cards[i] = temp1 - temp2;
                    if (dfs(cards, maxIndex - 1)) return true;

                    cards[i] = temp2 - temp1;
                    if (dfs(cards, maxIndex - 1)) return true;

                    cards[i] = temp1 * temp2;
                    if (dfs(cards, maxIndex - 1)) return true;

                    if (temp2 != 0) {
                        cards[i] = temp1 / temp2;
                        if (dfs(cards, maxIndex - 1)) return true;
                    }

                    if (temp1 != 0) {
                        cards[i] = temp2 / temp1;
                        if (dfs(cards, maxIndex - 1)) return true;
                    }

                    cards[j] = temp2;
                }
                cards[i] = temp1;
            }
            return false;
        }
    }
}
