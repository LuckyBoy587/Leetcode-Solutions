void main() {
    String[] stringArray = {"hot", "dot", "dog", "lot", "log", "cog"};
    List<String> wordList = Arrays.asList(stringArray);
    IO.println(new Solution().findLadders("hit", "cog", wordList));
}

private static class Solution {
    Map<String, List<String>> graph = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        PriorityQueue<List<String>> pq = new PriorityQueue<>(new PathComparator(endWord));
        pq.offer(List.of(beginWord));

        while (!pq.isEmpty()) {
            List<String> path = pq.poll();
            if (!res.isEmpty() && res.getFirst().size() < path.size()) continue;
            if (path.getLast().equals(endWord)) {
                if (res.isEmpty() || res.getFirst().size() == path.size()) res.add(new ArrayList<>(path));
                else if (res.getFirst().size() > path.size()) {
                    res.clear();
                    res.add(new ArrayList<>(path));
                }
                continue;
            }
            List<String> nextWords = graph.computeIfAbsent(path.getLast(), k -> findConnections(k, wordList));
            for (String nextWord: nextWords) {
                if (path.contains(nextWord)) continue;
                List<String> newPath = new ArrayList<>(path);
                newPath.add(nextWord);
                pq.offer(newPath);
            }
        }

        return res;
    }

    private List<String> findConnections(String word, List<String> wordList) {
        List<String> connections = new ArrayList<>();
        for (String next: wordList) {
            if (isConnected(word, next)) {
                connections.add(next);
            }
        }
        return connections;
    }

    private boolean isConnected(String word1, String word2) {
        return getDistance(word1, word2) == 1;
    }

    private int getDistance(String word1, String word2) {
        int difference = 0;
        for (int i = 0; i < word1.length() && difference <= 1; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                difference++;
            }
        }
        return difference;
    }

    private class PathComparator implements Comparator<List<String>> {
        private final String endWord;

        private PathComparator(String endWord) {
            this.endWord = endWord;
        }

        @Override
        public int compare(List<String> o1, List<String> o2) {
            return Integer.compare(getDistance(o1.getLast(), endWord), getDistance(o2.getLast(), endWord));
        }
    }
}
