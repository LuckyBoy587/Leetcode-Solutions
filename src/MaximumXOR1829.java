import java.util.Arrays;

public class MaximumXOR1829 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getMaximumXor(new int[]{2, 3, 4, 7}, 3)));
    }

    private static class Solution {
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int[] result = new int[nums.length];
            int maxVal = (1 << maximumBit) - 1;
            int currXOR = 0;
            for (int i = 0; i < nums.length; i++) {
                currXOR ^= nums[i];
                result[result.length - i - 1] = currXOR ^ maxVal;
            }
            return result;
        }
    }
}
