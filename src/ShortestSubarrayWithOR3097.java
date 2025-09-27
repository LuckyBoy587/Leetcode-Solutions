public class ShortestSubarrayWithOR3097 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumSubarrayLength(new int[]{2,1,9,12}, 21));
    }
    private static class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            if (k == 0) return 1;
            int[] bitCounts = new int[32];
            int currOR = 0;
            int minLength = Integer.MAX_VALUE;
            int left = 0, right = 0;

            outer:
            while (right < nums.length) {
                while (currOR < k) {
                    if (right == nums.length) break outer;
                    int num = nums[right++];
                    currOR |= num;
                    for (int i = 0; num > 0; i++) {
                        bitCounts[i] += num & 1;
                        num >>= 1;
                    }
                }
                while (currOR >= k) {
                    int num = nums[left++];
                    for (int i = 0; num > 0; i++) {
                        if (bitCounts[i] > 0) {
                            bitCounts[i] -= num & 1;
                            if (bitCounts[i] == 0) {
                                currOR &= ~(1 << i);
                            }
                        }
                        num >>= 1;
                    }
                }
                int currLen = right - left + 1;
                if (currLen < minLength) {
                    minLength = currLen;
                }
            }
            return minLength == Integer.MAX_VALUE ? -1 : minLength;
        }
    }
}
