public class StringCompressionIII3163 {
    public static void main(String[] args) {
        System.out.println(new Solution().compressedString("lllllllllla"));
    }
    private static class Solution {
        public String compressedString(String word) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char prev = word.charAt(0);

            for (char c : word.toCharArray()) {
                if (c == prev) {
                    count++;
                    if (count == 10) {
                        sb.append(9).append(c);
                        count = 1;
                    }
                } else {
                    sb.append(count).append(prev);
                    count = 1;
                    prev = c;
                }
            }
            sb.append(count).append(prev);
            return sb.toString();
        }
    }
}
