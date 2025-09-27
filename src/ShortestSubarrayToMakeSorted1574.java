public class ShortestSubarrayToMakeSorted1574 {
    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
    }

    private static class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int i = 0;
            while (i + 1 < arr.length && arr[i] <= arr[i + 1]) i++;

            int j = arr.length - 1;
            while (j >= 0 && arr[j] >= arr[j - 1]) j--;

            int left = 0, right = j;
            int result = Math.min(arr.length - i - 1, right);

            while (left < right) {
                if (arr[left] <= arr[right]) {
                    result = Math.min(result, right - left + 1);
                    left++;
                } else {
                    right--;
                }
            }
            return result;
        }

    }
}
