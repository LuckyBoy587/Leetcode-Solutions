void main() {
    int[] power = {5, 9, 2, 10, 2, 7, 10, 9, 3, 8};
    Solution solution = new Solution();
    System.out.println("Result: " + solution.maximumTotalDamage(power));
}

static class Solution {
    int[] keys = new int[3];
    long[] values = new long[3];

    private void swap() {
        keys[0] = keys[1];
        keys[1] = keys[2];

        values[0] = values[1];
        values[1] = values[2];
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        long res = 0;
        long currFreq = 0;
        int prevNum = power[0];
        for (int num : power) {
            if (num == prevNum) {
                currFreq++;
            } else {
                long currValue = prevNum * currFreq + values[0];
                res = Math.max(res, currValue);
                swap();
                keys[2] = prevNum;
                values[2] = currValue;
                currFreq = 1;
                prevNum = num;
            }
        }

        long currValue = prevNum * currFreq + values[0];
        res = Math.max(res, currValue);

//        TreeMap<Integer, Long> map = new TreeMap<>();
//        for (int num : power) {
//            map.merge(num, 1L, Long::sum);
//        }
//
//        TreeMap<Integer, Long> dp = new TreeMap<>();
//        dp.put(Integer.MIN_VALUE, 0L);
//
//        long res = 0;
//        for (var currEntry : map.entrySet()) {
//            long currValue = currEntry.getKey() * currEntry.getValue();
//            long prevChoosableValue = dp.floorEntry(currEntry.getKey() - 3).getValue();
//            long prevValue = dp.lastEntry().getValue();
//            long newValue = Math.max(prevValue, prevChoosableValue + currValue);
//            dp.put(currEntry.getKey(), newValue);
//            res = Math.max(res, newValue);
//        }
//
        return res;
    }
}