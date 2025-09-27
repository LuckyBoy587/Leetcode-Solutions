public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7};
        System.out.println(new Solution().search(arr, 4));
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            if (nums[left] > nums[right]) {
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] > nums[left]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
            } else {
                left = -1;
            }
            int start = left + 1, end = start + nums.length - 1;
            while (start <= end) {
                int mid = (start + (end - start) / 2);
                int midIndex = mid % nums.length;
                if (nums[midIndex] < target) {
                    start = mid + 1;
                } else if (nums[midIndex] > target) {
                    end = mid - 1;
                } else {
                    return midIndex;
                }
            }
            return -1;
        }
    }
}
