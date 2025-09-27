import java.util.HashMap;
import java.util.PriorityQueue;

public class DesignNumberContainerSystem2349 {
    private static class NumberContainers {
        HashMap<Integer, Integer> indexToNumber = new HashMap<>();
        HashMap<Integer, PriorityQueue<Integer>> numberToIndexes = new HashMap<>();
        public NumberContainers() {

        }

        public void change(int index, int number) {
            indexToNumber.put(index, number);
            numberToIndexes.computeIfAbsent(number, _ -> new PriorityQueue<>()).add(index);
        }

        public int find(int number) {
            PriorityQueue<Integer> indexes = numberToIndexes.get(number);
            if (indexes != null) {
                while (!indexes.isEmpty()) {
                    Integer index = indexes.peek();
                    if (indexToNumber.get(index) == number) {
                        return index;
                    }
                    indexes.poll();
                }
            }
            return -1;
        }
    }
}
