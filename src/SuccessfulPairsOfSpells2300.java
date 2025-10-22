void main() {
    int[] spells = {5, 1, 3};
    int[] potions = {1, 2, 3, 4, 5};
    long success = 7;
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.successfulPairs(spells, potions, success)));
}

private static class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            res[i] = count(potions, spells[i], success);
        }

        return res;
    }

    private int count(int[] potions, int spell, long success) {
        int left = 0, right = potions.length - 1;
        int res = potions.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) potions[mid] * spell >= success) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return potions.length - res;
    }
}