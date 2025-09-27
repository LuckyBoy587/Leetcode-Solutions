public class ProcessString {
    private static class Solution {
        public String processStr(String s) {
            StringBuilder sb = new StringBuilder();
            for (char letter : s.toCharArray()) {
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

            return sb.toString();
        }
    }
}
