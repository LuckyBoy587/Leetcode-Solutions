import java.util.StringTokenizer;

public class CompareVersionNumbers165 {
    private static class Solution {
        public int compareVersion(String version1, String version2) {
            StringTokenizer st1 = new StringTokenizer(version1, ".");
            StringTokenizer st2 = new StringTokenizer(version2, ".");

            while (st1.hasMoreTokens() && st2.hasMoreTokens()) {
                int comp = Integer.compare(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
                if (comp != 0) return comp;
            }
            while (st1.hasMoreTokens()) {
                if (Integer.parseInt(st1.nextToken()) != 0) {
                    return 1;
                }
            }
            while (st2.hasMoreTokens()) {
                if (Integer.parseInt(st2.nextToken()) != 0) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
