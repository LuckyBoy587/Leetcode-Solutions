import java.util.HashMap;
import java.util.List;

public class CountInterestingSubarrays2845 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3,2,4);
        System.out.println(new Solution().countInterestingSubarrays(nums, 2,1));
    }
    private static class Solution {
        public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
            int currModCount = 0;
            long res = 0;
            HashMap<Integer, Integer> modFreq = new HashMap<>();
            modFreq.put(0, 1);

            for (int num : nums) {
                currModCount += num % modulo == k ? 1 : 0;
                int targetModulo = (currModCount - k + modulo) % modulo;
                res += modFreq.getOrDefault(targetModulo, 0);
                modFreq.put(currModCount % modulo, modFreq.getOrDefault(currModCount % modulo, 0) + 1);
            }

            return res;
        }
    }
}
