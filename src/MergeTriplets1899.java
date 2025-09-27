import java.util.Arrays;

public class MergeTriplets1899 {
    private static class Solution {
        public boolean mergeTriplets(int[][] triplets, int[] target) {
            Trie root = new Trie();
            for (int[] triplet: triplets) {
                root.insert(triplet);
            }

            return root.search(target, 0);
        }
    }

    private static class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[10];
            Arrays.fill(children, null);
        }

        public void insert(int[] arr) {
            Trie curr = this;
            for (int num: arr) {
                if (curr.children[num] == null) {
                    curr.children[num] = new Trie();
                }

                curr = curr.children[num];
            }
        }

        public boolean search(int[] target, int index) {
            if (index == target.length) return true;
            if (children[target[index]] == null) return false;
            for (int i = 0; i <= target[index]; i++) {
                if (children[i] == null) continue;
                if (children[i].search(target, index + 1)) return true;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        int[][] triplets = {
                {2, 5, 3},
                {1, 8, 4},
                {1, 7, 5}
        };
        int[] target = {2, 7, 5};
        System.out.println(new Solution().mergeTriplets(triplets, target));
    }
}
