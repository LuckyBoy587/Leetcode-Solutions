import java.util.Arrays;

public class MinimumOperationToMoveBalls1769 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().minOperations("01")));
    }
    private static class Solution {
        public int[] minOperations(String boxes) {
            char[] letters = boxes.toCharArray();
            int n = letters.length;

            int[] leftCount = new int[n];
            int ballsSoFar = letters[0] - '0';
            for (int i = 1; i < n; i++) {
                leftCount[i] = leftCount[i - 1] + ballsSoFar;
                ballsSoFar += letters[i] - '0';
            }

            int[] rightCount = new int[n];
            ballsSoFar = letters[n - 1] - '0';
            for (int i = n - 2; i >= 0; i--) {
                rightCount[i] = rightCount[i + 1] + ballsSoFar;
                ballsSoFar += letters[i] - '0';
            }

            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = leftCount[i] + rightCount[i];
            }
            return result;
        }
    }
}
