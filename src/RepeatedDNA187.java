import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNA187 {
    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    private static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            HashSet<String> sequenceSet = new HashSet<>();
            HashSet<String> repeatedSet = new HashSet<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String currSequence = s.substring(i, i + 10);
                if (!sequenceSet.add(currSequence)) {
                    repeatedSet.add(currSequence);
                }
            }
            return new ArrayList<>(repeatedSet);
        }
    }
}
