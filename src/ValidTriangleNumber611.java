void main() {

}

private static class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int k = nums.length - 1; k >= 2; k--) {
            for (int j = k - 1; j >= 1; j--) {
                int target = nums[k] - nums[j];
                int i = binarySearch(nums, 0, j, target);
                res += j - i;
            }
        }

        return res;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}