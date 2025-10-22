void main() {
    int[] rains = {1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3};
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.avoidFlood(rains)));
}

private static class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> noRainIndexes = new ArrayList<>();
        int[] res = new int[rains.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                noRainIndexes.add(i);
            } else if (!map.containsKey(rains[i])) {
                map.put(rains[i], i);
            } else {
                int lowestIndex = lowestIndexGreaterThan(noRainIndexes, map.get(rains[i]));
                if (lowestIndex == -1) {
                    return new int[]{};
                }
                res[lowestIndex] = rains[i];
                noRainIndexes.remove(Integer.valueOf(lowestIndex));
                map.put(rains[i], i);
            }
        }
        for (int index: noRainIndexes) {
            res[index] = 1;
        }
        return res;
    }

    private int lowestIndexGreaterThan(List<Integer> noRainIndexes, int target) {
        if (noRainIndexes.isEmpty()) return -1;
        int left = 0, right = noRainIndexes.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (noRainIndexes.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left >= 0 && left < noRainIndexes.size() && noRainIndexes.get(left) > target ? noRainIndexes.get(left) : -1;
    }
}