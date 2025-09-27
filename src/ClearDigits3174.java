import java.util.ArrayList;
import java.util.List;

public class ClearDigits3174 {
    private static class Solution {
        public String clearDigits(String s) {
            List<Character> list = new ArrayList<>();
            for (char letter : s.toCharArray()) {
                if (Character.isLetter(letter)) {
                    list.add(letter);
                } else {
                    list.removeLast();
                }
            }
            return String.valueOf(list);
        }
    }
}
