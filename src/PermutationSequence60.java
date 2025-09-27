public class PermutationSequence60 {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(9, 300000));
        System.out.println("845697321");
    }

    private static class Solution {
        String res = null;
        int count = 0;

        public String getPermutation(int n, int k) {
            count = k;
            char[] nums = new char[n];
            for (int i = 0; i < n; i++) {
                nums[i] = (char) ('1' + i);
            }
            permutate(nums, 0, 0);
            return res;
        }

        private void permutate(char[] nums, int start, int visited) {
            if (start == nums.length) {
                count--;
                if (count == 0) {
                    res = new String(nums);
                }
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (isNotSetBit(visited, i)) {
                    nums[start] = (char) ('1' + i);
                    permutate(nums, start + 1, visited | (1 << i));
                    if (count == 0) return;
                }
            }
        }

        private boolean isNotSetBit(int visited, int pos) {
            return (visited & (1 << pos)) == 0;
        }

        private void swap(char[] nums, int i, int j) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
