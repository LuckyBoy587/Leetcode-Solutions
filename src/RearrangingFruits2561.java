import java.util.*;

public class RearrangingFruits2561 {
    public static void main(String[] args) {
        int[] basket1 = {84, 80, 43, 8, 80, 88, 43, 8, 100, 88};
        int[] basket2 = {32, 32, 42, 68, 68, 100, 42, 84, 14, 14};
        Solution solution = new Solution();
        System.out.println(solution.minCost(basket1, basket2));
        Arrays.sort(basket1);
        Arrays.sort(basket2);
        System.out.println(Arrays.toString(basket1) + "\n" + Arrays.toString(basket2));
    }

    private static class Solution {
        public long minCost(int[] basket1, int[] basket2) {
            Map<Integer, Integer> map = new HashMap<>();
            int minValue = Integer.MAX_VALUE;

            for (int key : basket1) {
                map.merge(key, 1, Integer::sum);
                minValue = Math.min(minValue, key);
            }

            for (int key : basket2) {
                map.merge(key, -1, Integer::sum);
                minValue = Math.min(minValue, key);
            }

            List<Integer> mergeKeys = new ArrayList<>();
            for (var entry : map.entrySet()) {
                int val = Math.abs(entry.getValue());
                if (val % 2 == 1) return -1;
                for (int x = 0; x < val / 2; x++) {
                    mergeKeys.add(entry.getKey());
                }
            }
            Collections.sort(mergeKeys);
            long res = 0;
            for (int i = 0; i < mergeKeys.size() / 2; i++) {
                res += Math.min(mergeKeys.get(i), minValue * 2);
            }
            return res;
        }
    }
}
