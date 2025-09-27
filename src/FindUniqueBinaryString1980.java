public class FindUniqueBinaryString1980 {
    public static void main(String[] args) {
        System.out.println(new Solution().findDifferentBinaryString(new String[]{"000", "001", "110"}));
    }

    private static class Solution {
        public String findDifferentBinaryString(String[] nums) {
            char[] res = new char[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i].charAt(i) == '0' ? '1' : '0';
            }
            return new String(res);
        }
    }
}
