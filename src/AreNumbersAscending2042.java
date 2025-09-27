import java.util.StringTokenizer;

public class AreNumbersAscending2042 {
    private static class Solution {
        public boolean areNumbersAscending(String s) {
            int prev = -1;
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                boolean isNumber = true;
                int currNum = 0;
                for (char digit : token.toCharArray()) {
                    if ('0' <= digit && digit <= '9') {
                        currNum = currNum * 10 + digit - '0';
                    } else {
                        isNumber = false;
                        break;
                    }
                }

                if (isNumber) {
                    if (prev >= currNum) {
                        return false;
                    }
                    prev = currNum;
                }
            }

            return true;
        }
    }
}
