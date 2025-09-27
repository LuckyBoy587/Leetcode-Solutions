import java.util.AbstractList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(4).get(12));
    }
    private static class Solution {
        public List<Integer> grayCode(int n) {
            return new AbstractList<>() {
                @Override
                public int size() {
                    return 1 << n;
                }

                @Override
                public Integer get(int index) {
                    return index ^ (index >> 1);
                }
            };
        }
    }
}
