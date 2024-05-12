import java.util.*;

public class GreedyBFS {

    public static Node greedyBestFirstSearch(Node start) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristic));
        Set<Node> explored = new HashSet<>();

        frontier.add(start);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            System.out.println("Visiting: " + current);

            if (current.heuristic == 0) { // Check if it's a goal node
                System.out.println("Goal node reached: " + current);
                return current;
            }

            explored.add(current);

            for (Map.Entry<Node, Integer> entry : current.neighbors.entrySet()) {
                Node neighbor = entry.getKey();
                if (!explored.contains(neighbor) && !frontier.contains(neighbor)) {
                    frontier.add(neighbor);
                }
            }
        }

        return null;
    }
}
