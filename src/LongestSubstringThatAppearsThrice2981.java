import java.util.HashMap;

public class LongestSubstringThatAppearsThrice2981 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength("aaaa"));
    }
    private static class Solution {
        public int maximumLength(String s) {
            HashMap<String, Integer> map = getSubstringFrequencyMap(s);

            String maxKey = "";
            for (String key : map.keySet()) {
                int currFreq = map.get(key);
                if (currFreq >= 3 && key.length() > maxKey.length()) {
                    maxKey = key;
                }
            }

            return map.get(maxKey) >= 3 ? maxKey.length() : -1;
        }

        private HashMap<String, Integer> getSubstringFrequencyMap(String s) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("", 0);
            char[] letters = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                int j = i - 1;
                StringBuilder sub = new StringBuilder(String.valueOf(letters[i]));
                while (j >= 0 && letters[j] == letters[i]) {
                    map.put(sub.toString(), map.getOrDefault(sub.toString(), 0) + 1);
                    sub.append(letters[j--]);
                }
                map.put(sub.toString(), map.getOrDefault(sub.toString(), 0) + 1);
            }
            return map;
        }
    }
}
