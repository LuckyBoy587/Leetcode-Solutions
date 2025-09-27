import java.util.HashSet;

public class NumberOfDifferentWays1805 {
    public static void main(String[] args) {
        System.out.println(new Solution().numDifferentIntegers("a1b01c001d0"));
    }
    private static class Solution {
        public int numDifferentIntegers(String word) {
            HashSet<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            boolean digitVisited = false;
            for (char letter : word.toCharArray()) {
                if (Character.isDigit(letter)) {
                    if (letter != '0' || !sb.isEmpty()) {
                        sb.append(letter);
                    }
                    digitVisited = true;
                } else if (digitVisited) {
                    digitVisited = false;
                    set.add(sb.toString());
                    sb.setLength(0);
                }
            }

            if (digitVisited) set.add(sb.toString());
            System.out.println(set);
            return set.size();
        }
    }
}
