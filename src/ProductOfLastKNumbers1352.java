import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNumbers1352 {
    private static class ProductOfNumbers {
        int last_zero_pos = -1;
        List<Integer> arr = new ArrayList<>();
        public ProductOfNumbers() {
            arr.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                last_zero_pos = arr.size();
                arr.add(1);
            } else {
                arr.add(num * arr.getLast());
            }
        }

        public int getProduct(int k) {
            System.out.print(k + " ");
            System.out.println(arr);
            int pos = arr.size() - k - 1;
            if (pos <= last_zero_pos) return 0;
            return arr.getLast() / arr.get(pos);
        }
    }
}
