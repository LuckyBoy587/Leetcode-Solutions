public class MaximumBalancedShipments {
    public static void main(String[] args) {
        System.out.println(new Solution().maxBalancedShipments(new int[]{2, 5, 1, 4, 3}));
    }

    private static class Solution {
        Integer[] memo;

        public int maxBalancedShipments(int[] weight) {
            memo = new Integer[weight.length];
            return find(weight, 0, 0);
        }

        private int find(int[] weight, int index, int maxSoFar) {
            if (index == weight.length) return 0;
            if (maxSoFar == 0 && memo[index] != null) return memo[index];
            int res = find(weight, index + 1, Math.max(maxSoFar, weight[index]));
            if (maxSoFar > 0 && weight[index] < maxSoFar) {
                res = Math.max(res, 1 + find(weight, index + 1, 0));
            }
            if (maxSoFar == 0) memo[index] = res;
            return res;
        }
    }
}
