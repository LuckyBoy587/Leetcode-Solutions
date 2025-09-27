public class NumberOfSubarraysWithOddSum1524 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution().numOfSubarrays(arr));
    }

    private static class Solution {
        public int numOfSubarrays(int[] arr) {
            int res = 0;
            int MOD = 1000000007;
            int prevOdd = 0, prevEven = 1, currSum = 0;
            for (int num : arr) {
                currSum += num;
                if (currSum % 2 == 0) {
                    res = (res + prevOdd) % MOD;
                    prevEven++;
                } else {
                    res = (res + prevEven) % MOD;
                    prevOdd++;
                }
            }
            return res;
        }
    }
}
