import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasketIII3479 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] fruits = {3, 6, 1};
        int[] baskets = {6, 4, 7};
        System.out.println("Number of unplaced fruits: " + solution.numOfUnplacedFruits(fruits, baskets));
    }

    private static class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int placed = 0;
            Basket[] basketObjs = new Basket[baskets.length];
            for (int i = 0; i < baskets.length; i++) {
                basketObjs[i] = new Basket(i, baskets[i]);
            }

            Arrays.sort(basketObjs, (b1, b2) -> {
                if (b1.size != b2.size) return b1.size - b2.size;
                return b1.index - b2.index;
            });

            Map<Integer, Integer> basketOriginalToSortedIndex = new HashMap<>();
            for (int i = 0; i < basketObjs.length; i++) {
                basketOriginalToSortedIndex.put(basketObjs[i].index, i);
            }

            SegmentTree tree = new SegmentTree(basketObjs);
            for (int fruit : fruits) {
                int left = 0, right = baskets.length - 1;
                int minIndex = -1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (basketObjs[mid].size >= fruit) {
                        minIndex = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                if (minIndex != -1) {
                    int originalIndex = tree.query(minIndex, baskets.length - 1);
                    if (originalIndex != Integer.MAX_VALUE) {
                        int sortedIndex = basketOriginalToSortedIndex.get(originalIndex);
                        tree.update(sortedIndex, Integer.MAX_VALUE);
                        placed++;
                    }
                }
            }

            return baskets.length - placed;
        }

        private static class Basket {
            int size, index;

            public Basket(int index, int size) {
                this.index = index;
                this.size = size;
            }
        }

        private static class SegmentTree {
            int[] tree;
            int n;

            public SegmentTree(Basket[] indexes) {
                n = indexes.length;
                tree = new int[2 * n];
                for (int i = n - 1; i >= 0; i--) {
                    update(i, indexes[i].index);
                }
            }

            private void update(int index, int value) {
                tree[index + n] = value;
                for (int i = (index + n) / 2; i > 0; i /= 2) {
                    tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
                }
            }

            private int query(int left, int right) {
                left += n;
                right += n;
                int min = Integer.MAX_VALUE;

                while (left <= right) {
                    if (left % 2 == 1) {
                        min = Math.min(min, tree[left]);
                        left++;
                    }
                    if (right % 2 == 0) {
                        min = Math.min(min, tree[right]);
                        right--;
                    }
                    left /= 2;
                    right /= 2;
                }
                return min;
            }
        }
    }
}
