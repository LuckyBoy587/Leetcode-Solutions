public class CountPrefixSuffix {
    private static class Solution {
        public int countPrefixSuffixPairs(String[] words) {
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].startsWith(words[j]) && words[i].endsWith(words[j])) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
