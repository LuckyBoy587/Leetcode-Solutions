import java.util.HashSet;
import java.util.Set;

public class BitwiseORSubarrays898 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subarrayBitwiseORs(new int[]{0}));
        System.out.println(sol.subarrayBitwiseORs(new int[]{1, 1, 2}));
        System.out.println(sol.subarrayBitwiseORs(new int[]{1, 2, 4}));
        System.out.println(sol.subarrayBitwiseORs(new int[]{9, 6, 15}));
    }

    private static class Solution {
        public int subarrayBitwiseORs(int[] arr) {
            Set<Integer> ans = new HashSet<>();
            Set<Integer> curr = new HashSet<>();
            for (int num : arr) {
                Set<Integer> next = new HashSet<>();
                next.add(num);
                ans.add(num);
                for (int prev : curr) {
                    next.add(prev | num);
                    ans.add(prev | num);
                }
                curr = next;
            }
            return ans.size();
        }
    }

}
