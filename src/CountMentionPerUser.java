import java.util.List;

public class CountMentionPerUser {
    private static class Solution {
        public int[] countMentions(int numberOfUsers, List<List<String>> events) {
            events.sort((e1, e2) -> {
                int t1 = Integer.parseInt(e1.get(1));
                int t2 = Integer.parseInt(e2.get(1));

                if (t1 != t2) return t1 - t2;
                return e2.getFirst().compareTo(e1.getFirst());
            });
            int[] offlineTill = new int[numberOfUsers];
            int[] res = new int[numberOfUsers];

            for (List<String> event : events) {
                int currTime = Integer.parseInt(event.get(1));
                if (event.getFirst().equals("MESSAGE")) {
                    String mentions = event.get(2);
                    if (mentions.equals("ALL")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            res[i]++;
                        }
                    } else if (mentions.equals("HERE")) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (currTime >= offlineTill[i]) {
                                res[i]++;
                            }
                        }
                    } else {
                        String[] ids = mentions.split(" ");
                        for (String id : ids) {
                            res[Integer.parseInt(id.substring(2))]++;
                        }
                    }
                } else {
                    int id = Integer.parseInt(event.get(2));
                    offlineTill[id] = currTime + 60;
                }
            }

            return res;
        }
    }
}
