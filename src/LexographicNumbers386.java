import java.util.ArrayList;
import java.util.List;

public class LexographicNumbers386 {
    private static class Solution {
        List<Integer> res = new ArrayList<>();

        public List<Integer> lexicalOrder(int n) {
            solve(0, n);
            return res;
        }

        public void solve(int num, int target) {
            if (num != 0) res.add(num);
            num *= 10;
            for (int i = 0; i <= 9; i++) {
                if (i == 0 && num == 0) continue;
                if (num + i > target) break;
                else solve(num + i, target);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lexicalOrder(130));
    }
}
