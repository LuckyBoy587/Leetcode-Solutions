import java.util.Arrays;

public class Candy135 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = {1, 3, 2, 2, 1};
        int result = solution.candy(ratings);
        System.out.println("Total candies required: " + result);
    }
    private static class Solution {
        public int candy(int[] ratings) {
            int[] res = new int[ratings.length];
            Arrays.fill(res, 1);

            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i - 1] < ratings[i]) {
                    res[i] = res[i - 1] + 1;
                }
            }

            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    res[i] = Math.max(res[i + 1] + 1, res[i]);
                }
            }

            int total = 0;
            for (int val : res) {
                total += val;
            }
            return total;
        }
    }
}
