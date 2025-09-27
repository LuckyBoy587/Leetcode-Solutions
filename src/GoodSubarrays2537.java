import java.util.HashMap;

public class GoodSubarrays2537 {
    public static void main(String[] args) {
        System.out.println(new Solution().countGood(new int[]{2,1,3,1,2,2,3,3,2,2,1,1,1,3,1}, 11));
    }
    private static class Solution {
        public long countGood(int[] nums, int k) {
            int pairCount = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int st = 0;
            long res = 0;
            for (int num : nums) {
                int freq = map.getOrDefault(num, 0);
                pairCount += freq;
                map.put(num, freq + 1);
                while (pairCount >= k) {
                    int startFreq = map.get(nums[st]);
                    pairCount -= startFreq - 1;
                    map.put(nums[st], startFreq - 1);
                    st++;
                }
                res += st;
            }

            return res;
        }
    }
}
