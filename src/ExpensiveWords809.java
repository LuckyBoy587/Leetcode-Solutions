import java.util.HashMap;
import java.util.Objects;

public class ExpensiveWords809 {
    public static void main(String[] args) {
        String s = "aaa";
        String[] words = {"aaaa"};
        System.out.println(new Solution().expressiveWords(s, words));
    }
    private static class Solution {
        public int expressiveWords(String s, String[] words) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int res = 0;
            for (String word : words) {
                HashMap<Character, Integer> checkMap = new HashMap<>();
                for (char c : word.toCharArray()) {
                    checkMap.put(c, checkMap.getOrDefault(c, 0) + 1);
                }

                if (map.keySet().equals(checkMap.keySet())) {
                    boolean flag = true;
                    for (char c : map.keySet()) {
                        int originalCount = map.get(c);
                        int checkCount = checkMap.get(c);

                        if ((originalCount >= 3 && originalCount < checkCount) || (originalCount < 3 && originalCount != checkCount)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
