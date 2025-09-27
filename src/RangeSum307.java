public class RangeSum307 {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(obj.sumRange(0, 2));
    }
    private static class NumArray {
        private final int[] tree;
        private final int size;

        public NumArray(int[] nums) {
            size = nums.length;
            tree = new int[size * 2];
            System.arraycopy(nums, 0, tree, size, size);
            for (int i = size - 1; i > 0; i--) {
                tree[i] = tree[2 * i + 1] + tree[2 * i];
            }
        }

        public void update(int index, int val) {
            index += size;
            tree[index] = val;
            while (index > 1) {
                index /= 2;
                tree[index] = tree[2 * index] + tree[2 * index + 1];
            }
        }

        public int sumRange(int left, int right) {
            left += size;
            right += size;
            int res = 0;

            while (left <= right) {
                if (left % 2 == 1) {
                    res += tree[left];
                    left++;
                }
                if (right % 2 == 0) {
                    res += tree[right];
                    right--;
                }
                left /= 2;
                right /= 2;
            }

            return res;
        }
    }
}
