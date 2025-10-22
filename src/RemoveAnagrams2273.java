void main() {
    
}

private static class Solution {
    public List<String> removeAnagrams(String[] words) {
        LinkedList<String> sortedStringList = new LinkedList<>();
        LinkedList<String> wordList = new LinkedList<>();
        String[] sorted = sortedWords(words);
        sortedStringList.add(sorted[0]);
        wordList.add(words[0]);
        for (int i = 0; i < words.length; i++) {
            if (!sortedStringList.getLast().equals(sorted[i])) {
                sortedStringList.add(sorted[i]);
                wordList.add(words[i]);
            }
        }
        return wordList;
    }

    private String[] sortedWords(String[] words) {
        String[] sorted = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] letters = words[i].toCharArray();
            Arrays.sort(letters);
            sorted[i] = new String(letters);
        }
        return sorted;
    }
}