void main() {
    IO.println(new Solution().findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5));
}

private static class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] modFreq = new int[value];
        for (int num : nums) {
            modFreq[((num % value) + value) % value]++;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < value; i++) {
            int curr = modFreq[i] * value + i;
            res = Math.min(res, curr);
        }

        return res;
    }
}