public class AlphabetBoard1138 {
    public static void main(String[] args) {
        System.out.println(new Solution().alphabetBoardPath("leet"));
    }

    private static class Solution {
        public String alphabetBoardPath(String target) {
            StringBuilder builder = new StringBuilder();
            Position curr = new Position(0, 0);
            for (char letter : target.toCharArray()) {
                Position next = letterToPosition(letter);
                builder.append("L".repeat(Math.max(0, curr.j - next.j)));
                builder.append("D".repeat(Math.max(0, next.i - curr.i)));
                builder.append("U".repeat(Math.max(0, curr.i - next.i)));
                builder.append("R".repeat(Math.max(0, next.j - curr.j)));
                curr = next;
                builder.append('!');
            }
            return builder.toString();
        }

        private Position letterToPosition(char letter) {
            int i = (letter - 'a') / 5;
            int j = (letter - 'a') % 5;
            return new Position(i, j);
        }

        static class Position {
            int i, j;

            Position(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
    }
}
