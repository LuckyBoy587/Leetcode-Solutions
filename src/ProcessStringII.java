public class ProcessStringII {
    private static class Solution {
        public char processStr(String s, long k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() && sb.length() < k; i++) {
                char letter = s.charAt(i);
                switch (letter) {
                    case '*':
                        sb.setLength(Math.max(0, sb.length() - 1));
                        break;
                    case '#':
                        sb.append(sb);
                        break;
                    case '%':
                        sb.reverse();
                        break;
                    default:
                        sb.append(letter);
                }
            }

            return sb.charAt( (int) (k - 1));
        }
    }
}
