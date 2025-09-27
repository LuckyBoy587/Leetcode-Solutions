public class XORTotal1863 {
    public static void main(String[] args) {
        System.out.println(new Solution().subsetXORSum(new int[]{5, 1, 6}));
    }

    private static class Solution {
        public int subsetXORSum(int[] nums) {
            return get(nums, 0);
        }

        private int get(int[] nums, int index) {
            return  -1;
        }
    }
}
