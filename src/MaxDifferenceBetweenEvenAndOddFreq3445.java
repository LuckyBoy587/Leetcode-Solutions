import java.util.*;

public class MaxDifferenceBetweenEvenAndOddFreq3445 {
    private static class Solution {
        public int minimizeMax(int[] nums, int p) {
            if (p == 0) return 0;
            Set<Integer> set = new TreeSet<>();
            HashMap<Integer, Integer> freqMap = new HashMap<>();

            int pairCount = 0;
            for (int num : nums) {
                int freq = freqMap.getOrDefault(num, 0) + 1;
                if (freq % 2 == 0) {
                    pairCount++;
                    set.remove(num);
                } else {
                    set.add(num);
                }
                freqMap.put(num, freq);
            }
            int[] diffArr = new int[set.size() - 1];

            Iterator<Integer> iterator = set.iterator();
            int prev = iterator.next();

            for (int i = 0; i < diffArr.length; i++) {
                int curr = iterator.next();
                diffArr[i] = curr - prev;
                prev = curr;
            }

            Arrays.sort(diffArr);
            System.out.println(Arrays.toString(diffArr));
            if (p <= pairCount) return 0;
            return diffArr[p - pairCount - 1];
        }
    }
}
