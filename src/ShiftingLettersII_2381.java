import java.util.Arrays;

public class ShiftingLettersII_2381 {
    public static void main(String[] args) {

    }
    private static class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            int[] shiftCount = new int[s.length()];
            for (int[] shift : shifts) {
                int dir = shift[2] == 1 ? 1 : -1;
                shiftCount[shift[0]] += dir;
                shiftCount[shift[1]] -= dir;
            }

            for (int i = 1; i < s.length(); i++) {
                shiftCount[i] += shiftCount[i - 1];
            }

            System.out.println(Arrays.toString(shiftCount));

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int letterValue = chars[i] - 'a' + shiftCount[i];
                letterValue = ((letterValue % 26) + 26) % 26;
                chars[i] = (char) (letterValue + 'a');
            }

            return new String(chars);
        }
    }
}
