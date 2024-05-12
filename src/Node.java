import java.util.HashMap;
import java.util.Map;

public class Node {
    String label;
    int heuristic;
    int cost;
    Node parent;
    Map<Node, Integer> neighbors;

    public Node(String label, int heuristic) {
        this.label = label;
        this.heuristic = heuristic;
        this.cost = Integer.MAX_VALUE;
        this.parent = null;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(Node neighbor, int edgeCost) {
        this.neighbors.put(neighbor, edgeCost);
        neighbor.neighbors.put(this, edgeCost);
    }

    public String toString() {
        return this.label + " (h=" + this.heuristic + ", g=" + this.cost + ")";
    }
}
