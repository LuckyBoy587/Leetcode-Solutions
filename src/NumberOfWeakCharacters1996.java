import java.util.Arrays;

public class NumberOfWeakCharacters1996 {
    private static class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties, (p1, p2) -> {
                if (p1[0] != p2[0]) return p2[0] - p1[0];
                return p1[1] - p2[1];
            });
            return -1;
        }
    }
}
