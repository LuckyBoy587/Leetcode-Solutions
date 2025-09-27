import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        String[] words = {"glarko", "zlfiwwb", "nsfspyox", "pwqvwmlgri", "qggx", "qrkgmliewc", "zskaqzwo", "zskaqzwo", "ijy", "htpvnmozay", "jqrlad", "ccjel", "qrkgmliewc", "qkjzgws", "fqizrrnmif", "jqrlad", "nbuorw", "qrkgmliewc", "htpvnmozay", "nftk", "glarko", "hdemkfr", "axyak", "hdemkfr", "nsfspyox", "nsfspyox", "qrkgmliewc", "nftk", "nftk", "ccjel", "qrkgmliewc", "ocgjsu", "ijy", "glarko", "nbuorw", "nsfspyox", "qkjzgws", "qkjzgws", "fqizrrnmif", "pwqvwmlgri", "nftk", "qrkgmliewc", "jqrlad", "nftk", "zskaqzwo", "glarko", "nsfspyox", "zlfiwwb", "hwlvqgkdbo", "htpvnmozay", "nsfspyox", "zskaqzwo", "htpvnmozay", "zskaqzwo", "nbuorw", "qkjzgws", "zlfiwwb", "pwqvwmlgri", "zskaqzwo", "qengse", "glarko", "qkjzgws", "pwqvwmlgri", "fqizrrnmif", "nbuorw", "nftk", "ijy", "hdemkfr", "nftk", "qkjzgws", "jqrlad", "nftk", "ccjel", "qggx", "ijy", "qengse", "nftk", "htpvnmozay", "qengse", "eonrg", "qengse", "fqizrrnmif", "hwlvqgkdbo", "qengse", "qengse", "qggx", "qkjzgws", "qggx", "pwqvwmlgri", "htpvnmozay", "qrkgmliewc", "qengse", "fqizrrnmif", "qkjzgws", "qengse", "nftk", "htpvnmozay", "qggx", "zlfiwwb", "bwp", "ocgjsu", "qrkgmliewc", "ccjel", "hdemkfr", "nsfspyox", "hdemkfr", "qggx", "zlfiwwb", "nsfspyox", "ijy", "qkjzgws", "fqizrrnmif", "qkjzgws", "qrkgmliewc", "glarko", "hdemkfr", "pwqvwmlgri"};
        System.out.println(new Solution().topKFrequent(words, 14));
    }

    private static class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
                int f1 = map.get(o1);
                int f2 = map.get(o2);

                if (f1 != f2) return Integer.compare(f1, f2);
                return o2.compareTo(o1);
            });

            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            for (String word : map.keySet()) {
                if (pq.size() < k) pq.add(word);
                else {
                    int prev = map.get(pq.peek());
                    int curr = map.get(word);
                    if (curr > prev || (curr == prev && word.compareTo(Objects.requireNonNull(pq.peek())) < 0)) {
                        pq.poll();
                        pq.add(word);
                    }
                }
            }
            List<String> res = new ArrayList<>();
            while (!pq.isEmpty()) {
                res.add(pq.poll());
            }
            Collections.reverse(res);
            return res;
        }
    }
}
