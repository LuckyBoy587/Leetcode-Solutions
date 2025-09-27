import java.util.*;

public class SortCharactersByFrequency451 {
    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("Aabb"));
    }
    private static class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            char[] letters = s.toCharArray();
            for (char letter: letters) {
                map.put(letter, map.getOrDefault(letter, 0) + 1);
            }

            List<Character> sortedKeys = new ArrayList<>(map.keySet());
            sortedKeys.sort((a, b) -> map.get(b) - map.get(a));
            StringBuilder sb = new StringBuilder();
            for (Character key: sortedKeys) {
                int count = map.get(key);
                while (count-- > 0) sb.append(key);
            }
            return sb.toString();
        }
    }
}
