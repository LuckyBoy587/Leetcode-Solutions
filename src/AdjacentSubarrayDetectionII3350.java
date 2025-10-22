void main() {
    Solution solution = new Solution();
    List<Integer> nums = Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
    int result = solution.maxIncreasingSubarrays(nums);
    System.out.println("Result: " + result);
}

private static class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prevLen = 0, currLen = 0, maxLen = 0;
        int prevNum = -10001;
        int res = 0;
        for (int num: nums) {
            if (num > prevNum) currLen++;
            else {
                res = Math.max(res, Math.min(currLen, prevLen));
                maxLen = Math.max(maxLen, currLen);
                prevLen = currLen;
                currLen = 1;
            }
            prevNum = num;
        }

        maxLen = Math.max(maxLen, currLen);
        res = Math.max(res, Math.min(currLen, prevLen));
        return Math.max(maxLen / 2, res);
    }
}