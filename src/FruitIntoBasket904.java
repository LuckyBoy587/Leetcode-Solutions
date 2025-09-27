public class FruitIntoBasket904 {
    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[]{1, 2, 1}));
        System.out.println(new Solution().totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(new Solution().totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(new Solution().totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    private static class Solution {
        public int totalFruit(int[] fruits) {
            int n = fruits.length;
            if (n <= 2) return n;
            int basket1 = -1, basket2 = -1;
            int lastSeenIndex1 = -1, lastSeenIndex2 = -1, prevEndIndex = -1;
            int maxFruits = 0;

            for (int i = 0; i < n; i++) {
                int fruit = fruits[i];
                if (basket1 == -1) {
                    basket1 = fruit;
                    lastSeenIndex1 = i;
                } else if (fruit == basket1) {
                    lastSeenIndex1 = i;
                } else if (basket2 == -1) {
                    basket2 = fruit;
                    lastSeenIndex2 = i;
                } else if (fruit == basket2) {
                    lastSeenIndex2 = i;
                } else {
                    maxFruits = Math.max(maxFruits, i - prevEndIndex - 1);
                    prevEndIndex = Math.min(lastSeenIndex1, lastSeenIndex2);
                    if (lastSeenIndex1 < lastSeenIndex2) {
                        basket1 = fruit;
                        lastSeenIndex1 = i;
                    } else {
                        basket2 = fruit;
                        lastSeenIndex2 = i;
                    }
                }
            }
            maxFruits = Math.max(maxFruits, n - prevEndIndex - 1);
            return maxFruits;
        }
    }
}
