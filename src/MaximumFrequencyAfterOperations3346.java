void main() {
    Solution solution = new Solution();
    int[] nums = {1, 90};
    int k = 75;
    int numOperations = 1;
    int result = solution.maxFrequency(nums, k, numOperations);
    System.out.println("Result: " + result);
}

private static class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int[] minAndMax = getMinAndMax(nums);
        int offset = -minAndMax[0] + k;
        int size = minAndMax[1] + 10 + offset + k;

        int[] range = new int[size];
        int[] freqBeforeOperations = new int[size];
        for (int num : nums) {
            freqBeforeOperations[num + offset]++;
            addToRange(range, num + offset, k);
        }

        int[] freqAfterOperations = new int[size];
        freqAfterOperations[0] = range[0];
        for (int i = 1; i < size; i++) {
            freqAfterOperations[i] = freqAfterOperations[i - 1] + range[i];
        }

        int maxFreq = 0;
        for (int i = 0; i < size; i++) {
            int currBefore = freqBeforeOperations[i];
            int currAfter = freqAfterOperations[i];
            maxFreq = Math.max(maxFreq, Math.max(currBefore, Math.min(currAfter, currBefore + numOperations)));
        }

        return maxFreq;
    }

    private void addToRange(int[] range, int num, int k) {
        range[num - k]++;
        range[num + k + 1]--;
    }

    private int[] getMinAndMax(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return new int[]{min, max};
    }
}