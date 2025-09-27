public class DesignSpreadsheet3484 {
    private static class Spreadsheet {
        int[][] sheet;

        public Spreadsheet(int rows) {
            this.sheet = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int[] pos = parseCell(cell);
            sheet[pos[0]][pos[1]] = value;
        }

        public void resetCell(String cell) {
            int[] pos = parseCell(cell);
            sheet[pos[0]][pos[1]] = 0;
        }

        public int getValue(String formula) {
            String[] parts = formula.split("\\+");
            String part1 = parts[0].substring(1);
            String part2 = parts[1];
            return valueOf(part1) + valueOf(part2);
        }

        private int valueOf(String part) {
            try {
                return Integer.parseInt(part);
            } catch (NumberFormatException e) {
                int[] pos = parseCell(part);
                return sheet[pos[0]][pos[1]];
            }
        }

        private int[] parseCell(String cell) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.parseInt(cell.substring(1)) - 1;
            return new int[]{row, col};
        }
    }
}
