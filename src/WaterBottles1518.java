void main() {
    
}

private static class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0;
        int res = 0;

        while (numBottles > 0 || empty >= numExchange) {
            res += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty %= numExchange;
        }

        return res;
    }
}