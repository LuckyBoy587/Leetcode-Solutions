import java.util.HashMap;
import java.util.List;

public class EvaluateBracketPairs1807 {
    private static class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            HashMap<String, String> map = new HashMap<>();
            for (List<String> l : knowledge) {
                map.put(l.get(0), l.get(1));
            }

            StringBuilder res = new StringBuilder();
            StringBuilder key = new StringBuilder();

            boolean isKeyLetters = false;

            for (char letter : s.toCharArray()) {
                if (letter == '(') isKeyLetters = true;
                else if (letter == ')') {
                    isKeyLetters = false;
                    res.append(map.getOrDefault(key.toString(), "?"));
                    key.setLength(0);
                } else if (isKeyLetters) {
                    key.append(letter);
                } else {
                    res.append(letter);
                }
            }

            return res.toString();
        }
    }
}
