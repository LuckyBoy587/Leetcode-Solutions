void main() {

    
}

private static class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0, prevDevice = 0;
        for (int i = 0; i < bank.length; i++) {
            int currDevice = 0;
            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    currDevice++;
                }
            }

            if (currDevice > 0) {
                res += prevDevice * currDevice;
                prevDevice = currDevice;
            }
        }

        return res;
    }
}