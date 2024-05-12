import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class AStarSearch {

    public static Node aStarSearch(Node start) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost + n.heuristic));
        Set<Node> explored = new HashSet<>();

        start.cost = 0;
        frontier.add(start);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            System.out.println("Visiting: " + current);

            if (current.heuristic == 0) {
                System.out.println("Goal node reached: " + current);
                return current;
            }

            explored.add(current);

            for (Map.Entry<Node, Integer> entry : current.neighbors.entrySet()) {
                Node neighbor = entry.getKey();
                int edgeCost = entry.getValue();
                int tentative_gScore = current.cost + edgeCost;

                if (!explored.contains(neighbor) && tentative_gScore < neighbor.cost) {
                    neighbor.parent = current;
                    neighbor.cost = tentative_gScore;

                    if (!frontier.contains(neighbor)) {
                        frontier.add(neighbor);
                    } else {
                        frontier.remove(neighbor);
                        frontier.add(neighbor);
                    }
                }
            }
        }

        return null;
    }
}

