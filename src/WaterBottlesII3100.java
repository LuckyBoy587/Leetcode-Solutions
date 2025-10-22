void main() {
    
}

private static class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = 0, empty = 0;
        while (numBottles > 0) {
            total += numBottles;
            empty += numBottles;
            numBottles = 0;
            while (empty >= numExchange) {
                numBottles++;
                empty -= numExchange;
                numExchange++;
            }
        }

        return total;
    }
}