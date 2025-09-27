public class CanIWin464 {
    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(10, 11));
    }
    private static class Solution {
        enum Player {
            ONE, TWO
        }

        Player[] map;
        boolean hasExceeded = false;
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (desiredTotal == 0) return true;
            map = new Player[1 << maxChoosableInteger + 1];
            return getWinner(desiredTotal, maxChoosableInteger, 0, Player.ONE) == Player.ONE && hasExceeded;
        }

        private Player getWinner(int total, int maxInt, int visited, Player current) {
            if (total <= 0) {
                hasExceeded = true;
                return current == Player.ONE ? Player.TWO : Player.ONE;
            }
            if (map[visited] != null) return map[visited];
            for (int i = 1; i <= maxInt; i++) {
                if (!isSetBit(visited, i)) {
                    Player winner = getWinner(total - i, maxInt, visited | (1 << i), current == Player.ONE ? Player.TWO : Player.ONE);
                    if (winner == current) {
                        return map[visited] = winner;
                    }
                }
            }
            return map[visited] = current == Player.ONE ? Player.TWO : Player.ONE;
        }

        private boolean isSetBit(int num, int pos) {
            return (num & (1 << pos)) != 0;
        }
    }
}
