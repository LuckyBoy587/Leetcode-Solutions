import java.util.*;

public class SubstringOfAllWords30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        System.out.println(new Solution().findSubstring(s, words));
    }

    private static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            int subLen = words[0].length();
            List<Integer> res = new ArrayList<>();
            List<String> set = new ArrayList<>(Arrays.asList(words));
            Map<String, Integer> freq = new HashMap<>();
            for (String word : words) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
            for (int i = 0; i < s.length() - (subLen * words.length) + 1; i++) {
                if (search(s, freq, subLen, words.length, i)) res.add(i);
            }
            return res;
        }

        public boolean search(String s, List<String> words, int subLength, int start) {
            if (words.isEmpty()) return true;
            String currSub = s.substring(start, start + subLength);
            if (words.contains(currSub)) {
                words.remove(currSub);
                boolean ans = search(s, words, subLength, start + subLength);
                words.add(currSub);
                return ans;
            }
            return false;
        }

        public boolean search(String s, Map<String, Integer> words, int subLength, int subCount, int start) {
            Map<String, Integer> seenWords = new HashMap<>();
            for (int i = 0; i < subCount; i++) {
                int index = start + (subLength * i);
                String currSub = s.substring(index, index + subLength);
                if (!words.containsKey(currSub)) return false;
                seenWords.put(currSub, seenWords.getOrDefault(currSub, 0) + 1);
                if (seenWords.get(currSub) > words.get(currSub)) return false;
            }
            return true;
        }
    }
}
