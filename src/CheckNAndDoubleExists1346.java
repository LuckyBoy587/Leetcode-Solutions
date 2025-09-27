import java.util.HashSet;
import java.util.Set;

public class CheckNAndDoubleExists1346 {
    public static void main(String[] args) {
        int[] array = {-1000, -500, 1000};
        System.out.println(new Solution().checkIfExist(array));
    }
    private static class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> visited = new HashSet<>();
            for (int num : arr) {
                if (visited.contains(num * 2)) {
                    return true;
                }
                if (num % 2 == 0 && visited.contains(num / 2)) {
                    return true;
                }
                visited.add(num);
            }
            return false;
        }
    }
}
