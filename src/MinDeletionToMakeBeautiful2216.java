public class MinDeletionToMakeBeautiful2216 {
    public static void main(String[] args) {
        System.out.println(new Solution().minDeletion(new int[]{1, 1, 2, 3, 5}));
    }

    private static class Solution {
        public int minDeletion(int[] nums) {
            int prev = -1, count = 0;
            for (int num : nums) {
                if ((count % 2) == 0 || prev != num) {
                    prev = num;
                    count++;
                }
            }
            int res = nums.length - count;
            return (nums.length - res) % 2 == 0 ? res : res + 1;
        }
    }
}
