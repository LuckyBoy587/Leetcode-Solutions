import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MostBeautifulItemForEachQuery2070 {
    public static void main(String[] args) {
        int[][] coordinates = {
                {193, 732},
                {781, 962},
                {864, 954},
                {749, 627},
                {136, 746},
                {478, 548},
                {640, 908},
                {210, 799},
                {567, 715},
                {914, 388},
                {487, 853},
                {533, 554},
                {247, 919},
                {958, 150},
                {193, 523},
                {176, 656},
                {395, 469},
                {763, 821},
                {542, 946},
                {701, 676}
        };
        int[] queries = {885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
        System.out.println(Arrays.toString(new Solution().maximumBeauty(coordinates, queries)));
    }
    private static class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            Arrays.sort(items, Comparator.comparingInt(arr -> arr[0]));
            System.out.println(Arrays.deepToString(items));
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(Integer.MIN_VALUE, 0);
            for (int[] item : items) {
                int beauty = item[1];
                int prevBeauty = map.floorEntry(item[0] - 1).getValue();
                map.put(item[0], Math.max(Math.max(map.getOrDefault(item[0], 0), prevBeauty), beauty));
            }
            System.out.println(map);
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = map.floorEntry(queries[i]).getValue();
            }
            return res;
        }
    }
}
