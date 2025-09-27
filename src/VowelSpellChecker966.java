import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VowelSpellChecker966 {
    private static class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {
            Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));
            HashMap<String, String> caseMap = new HashMap<>();
            HashMap<String, String> regexMap = new HashMap<>();
            for (String word : wordlist) {
                String regex = toRegex(word);
                regexMap.putIfAbsent(regex, word);
                caseMap.putIfAbsent(word.toLowerCase(), word);
            }

            String[] result = new String[queries.length];
            for (int i = 0; i < queries.length; i++) {
                String query = queries[i];
                if (exactWords.contains(query)) {
                    result[i] = query;
                } else if (caseMap.containsKey(query.toLowerCase())) {
                    result[i] = caseMap.get(query.toLowerCase());
                } else {
                    String regex = toRegex(query);
                    result[i] = regexMap.getOrDefault(regex, "");
                }
            }

            return result;
        }

        private String toRegex(String word) {
            return word.toLowerCase().replaceAll("[aeiou]", ".");
        }
    }
}
