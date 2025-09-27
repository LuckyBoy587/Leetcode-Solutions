public class NeighbouringBitwiseXOR2683 {
    private static class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            int res = 0;
            for (int num : derived) {
                res ^= num;
            }
            return res == 0;
        }
    }
}
