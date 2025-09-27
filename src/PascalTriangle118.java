import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 1) return new ArrayList<>() {{
                add(List.of(1));
            }};

            List<List<Integer>> prev = generate(numRows - 1);
            List<Integer> prevRow = prev.getLast();
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int i = 1; i < prevRow.size(); i++) {
                curr.add(prevRow.get(i - 1) + prevRow.get(i));
            }
            curr.add(1);
            prev.add(curr);
            return prev;
        }
    }
}
