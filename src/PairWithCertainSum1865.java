import java.util.HashMap;

public class PairWithCertainSum1865 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        int[] nums2 = {1, 4, 5, 2, 5, 4};
        FindSumPairs findSumPairs = new FindSumPairs(nums1, nums2);
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }
    private static class FindSumPairs {
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int[] nums1, nums2;
        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;

            for (int val: nums2) {
                map2.merge(val, 1, Integer::sum);
            }
        }

        public void add(int index, int val) {
            map2.merge(nums2[index], -1, Integer::sum);
            nums2[index] += val;
            map2.merge(nums2[index], 1, Integer::sum);
        }

        public int count(int tot) {
            int count = 0;
            for (int n1: nums1) {
                int n2 = tot - n1;
                if (map2.containsKey(n2)) {
                    count += map2.get(n2);
                }
            }

            return count;
        }
    }
}
