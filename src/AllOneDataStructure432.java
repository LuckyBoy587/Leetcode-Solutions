import java.util.HashMap;
import java.util.TreeSet;

public class AllOneDataStructure432 {
    private static class AllOne {
        private final TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            int cmp = Integer.compare(a.value, b.value);
            if (cmp == 0) return a.key.compareTo(b.key);
            return cmp;
        });

        private final HashMap<String, Integer> freqMap = new HashMap<>();

        public AllOne() {

        }

        public void inc(String key) {
            int freq = freqMap.getOrDefault(key, 0);
            freqMap.put(key, freq + 1);
            set.remove(new Pair(key, freq));
            set.add(new Pair(key, freq + 1));
        }

        public void dec(String key) {
            int freq = freqMap.getOrDefault(key, 0);
            freqMap.put(key, freq - 1);
            set.remove(new Pair(key, freq));
            if (freq > 1) {
                set.add(new Pair(key, freq - 1));
            }
        }

        public String getMaxKey() {
            System.out.println(set);
            if (set.isEmpty()) return "";
            return set.last().key;
        }

        public String getMinKey() {
            System.out.println(set);
            if (set.isEmpty()) return "";
            return set.first().key;
        }

        static class Pair {
            String key;
            Integer value;

            public Pair(String key, Integer value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "key='" + key + '\'' +
                        ", value=" + value +
                        '}';
            }
        }
    }
}
