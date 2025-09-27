import java.util.Arrays;
import java.util.HashMap;

public class MakeSumDivisibleByP1590 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 2};
        int p = 7;
        System.out.println(new Solution().minSubarray(arr, p));
        System.out.println(new Solution().findSmallestSubarray(arr, p, 3));
    }
    private static class Solution {
        public int minSubarray(int[] nums, int p) {
            int sum = 0;
            for (int n : nums) {
                sum += n % p;  // Calculate the sum of elements modulo p
            }

            int k = sum % p;  // Calculate the remainder of the total sum modulo p
            if (k == 0) return 0;  // If the remainder is 0, the entire array sum is divisible by p

            int[] rem = new int[p];  // Initialize the remainder array with size p
            Arrays.fill(rem, -1);  // Fill the array with -1 to indicate uninitialized positions

            int prev = 0;
            int minlen = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                int curr = (nums[i] + prev) % p;  // Calculate the current remainder
                System.out.println("i: " + i + ", nums[i]: " + nums[i] + ", prev: " + prev + ", curr: " + curr);
                if (rem[curr] != -1) {  // If the current remainder has been seen before
                    minlen = Math.min(minlen, i - rem[curr]);  // Update the minimum length
                }
                rem[curr] = i;  // Update the remainder array with the current index
                prev = curr;  // Update prev to the current remainder
            }

            return minlen != Integer.MAX_VALUE ? minlen : -1;  // Return the minimum length or -1 if no valid subarray is found

        }

        private int findSmallestSubarray(int[] nums, int p, int remainder) {
            int prefixSum = 0;
            int minLength = nums.length;
            HashMap<Integer, Integer> prefixMap = new HashMap<>();
            prefixMap.put(0, -1);  // Initial condition for no subarray

            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                int targetRemainder = (prefixSum % p - remainder + p) % p;

                if (prefixMap.containsKey(targetRemainder)) {
                    minLength = Math.min(minLength, i - prefixMap.get(targetRemainder));
                }

                prefixMap.put(prefixSum % p, i);
            }

            return minLength < nums.length ? minLength : -1;
        }
    }
}
