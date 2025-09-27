public class MinimumEqualSum2918 {
    private static class Solution {
        public long minSum(int[] nums1, int[] nums2) {
            Value v1 = new Value(nums1);
            Value v2 = new Value(nums2);
            return get(v1, v2);
        }

        private long get(Value v1, Value v2) {
            long min1 = v1.minSum();
            long min2 = v2.minSum();

            if (min1 < min2 && v1.zeroCount == 0) return -1;
            if (min2 < min1 && v2.zeroCount == 0) return -1;

            return Math.max(min1, min2);
        }

        static class Value {
            long sum = 0;
            int zeroCount = 0;

            Value(int[] arr) {
                for (int num: arr) {
                    if (num == 0) {
                        zeroCount++;
                    } else {
                        sum += num;
                    }
                }
            }

            public long minSum() {
                return sum + zeroCount;
            }
        }
    }
}
