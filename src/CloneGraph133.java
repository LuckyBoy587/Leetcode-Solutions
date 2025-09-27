import java.util.*;

public class CloneGraph133 {
    // Definition for a Node.
    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                if (graph.containsKey(curr.val)) continue;
                graph.put(curr.val, new ArrayList<>());
                for (Node neighbor : curr.neighbors) {
                    graph.get(curr.val).add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            Node[] clonedNodesArray = new Node[graph.size()];
            for (int i = 0; i < clonedNodesArray.length; i++) {
                clonedNodesArray[i] = new Node(i + 1);
            }
            for (int key : graph.keySet()) {
                List<Integer> neighbors = graph.get(key);
                for (int neighbor : neighbors) {
                    clonedNodesArray[key - 1].neighbors.add(clonedNodesArray[neighbor - 1]);
                }
            }
            return clonedNodesArray[node.val - 1];
        }
    }
}
