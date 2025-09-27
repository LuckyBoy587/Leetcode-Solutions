import java.util.ArrayList;
import java.util.List;

public class SegmentSort3011 {
    public static void main(String[] args) {
        System.out.println(new Solution().canSortArray(new int[]{8,4,2,30,15}));
    }

    private static class Solution {
        public boolean canSortArray(int[] nums) {
            List<Segment> segments = new ArrayList<>();
            Segment currSegment = new Segment(nums[0], nums[0], countSetBits(nums[0]));
            for (int i = 1; i < nums.length; i++) {
                int currCount = countSetBits(nums[i]);
                if (currCount == currSegment.bitCount) {
                    currSegment.max = Integer.max(currSegment.max, nums[i]);
                    currSegment.min = Integer.min(currSegment.min, nums[i]);
                } else {
                    segments.add(currSegment);
                    currSegment = new Segment(nums[i], nums[i], currCount);
                }
            }
            segments.add(currSegment);
            for (int i = 1; i < segments.size(); i++) {
                Segment current = segments.get(i);
                Segment prev = segments.get(i - 1);
                if (current.min < prev.max) return false;
            }
            return true;
        }

        private int countSetBits(int num) {
            int res = 0;
            while (num > 0) {
                res += num & 1;
                num >>= 1;
            }
            return res;
        }

        static class Segment {
            int min, max, bitCount;

            public Segment(int min, int max, int bitCount) {
                this.min = min;
                this.max = max;
                this.bitCount = bitCount;
            }
        }
    }
}
