import java.util.Arrays;

public class ZeroArrayTransformationI3355 {

    public static void main(String[] args) {
        // Test input
        int[] nums = {1, 0, 1};
        int[][] queries = {{0, 2}};

        Solution solution = new Solution();
        boolean result = solution.isZeroArray(nums, queries);

        // Output result
        System.out.println("Result: " + result);
    }
    private static class Solution {
        public boolean isZeroArray(int[] nums, int[][] queries) {
            int n = nums.length;
            int[] diffArr = new int[n + 1];
            diffArr[0] = nums[0];
            for (int i = 1; i < n; i++) {
                diffArr[i] = nums[i] - nums[i - 1];
            }

            for (int[] query : queries) {
                int l = query[0];
                int r = query[1];
                diffArr[l]--;
                diffArr[r + 1]++;
            }

            if (diffArr[0] > 0) return false;
            nums[0] = diffArr[0];
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] + diffArr[i] > 0) return false;
                nums[i] = nums[i - 1] + diffArr[i];
            }
            System.out.println(Arrays.toString(diffArr));
            return true;
        }
    }
}
