import java.util.Map;
import java.util.TreeMap;

public class MyCalender729 {
    static class MyCalendar {
        TreeMap<Integer, Integer> map;
        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> higherEntry = map.higherEntry(start);
            Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(start);

            if (higherEntry != null && higherEntry.getKey() < end) {
                return false;
            }

            if (lowerEntry != null && lowerEntry.getValue() > start) {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }
}
