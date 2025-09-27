import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }

    private static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            return new AbstractList<>() {
                private List<List<Integer>> res = null;
                @Override
                public List<Integer> get(int index) {
                    return res.get(index);
                }

                @Override
                public int size() {
                    if (res == null) {
                        res = new ArrayList<>();
                        search(n, k, new ArrayList<>());
                    }
                    return res.size();
                }

                private void search(int n, int k, List<Integer> curr) {
                    if (k == 0) {
                        res.add(new ArrayList<>(curr));
                    } else {
                        for (int num = n; num >= 1; num--) {
                            curr.add(num);
                            search(num - 1, k - 1, curr);
                            curr.removeLast();
                        }
                    }
                }
            };
        }
    }
}
