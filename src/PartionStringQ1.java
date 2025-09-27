import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartionStringQ1 {
    private static class Solution {
        public List<String> partitionString(String s) {
            Set<String> visited = new HashSet<>();
            List<String> segments = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            for (char letter : s.toCharArray()) {
                sb.append(letter);
                String curr = sb.toString();
                if (!visited.contains(curr)) {
                    visited.add(curr);
                    segments.add(curr);
                    sb.setLength(0);
                }
            }

            return segments;
        }
    }
}
