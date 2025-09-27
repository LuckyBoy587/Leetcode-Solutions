void main() {
    Solution s = new Solution();
    IO.println(s.fractionToDecimal(1, Integer.MIN_VALUE));
}

private static class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        return get(numerator, denominator);
    }

    private String get(long numerator, long denominator) {
        if (numerator == 0) return "0";
        HashMap<Long, Integer> map = new HashMap<>(); // remainder -> position
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
            sb.append("-");
        }
        sb.append(numerator / denominator);
        numerator = (numerator % denominator) * 10;
        if (numerator == 0) return sb.toString();
        sb.append(".");

        for (int index = sb.length(); numerator != 0; index++) {
            long remainder = numerator % denominator;
            sb.append(numerator / denominator);
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder) + 1;
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
            map.put(remainder, index);
            numerator = remainder * 10;
        }

        return sb.toString();
    }
}