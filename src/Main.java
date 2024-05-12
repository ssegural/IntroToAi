import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Node nodeA = new Node("A", 15);
        Node nodeB = new Node("B", 4);
        Node nodeC = new Node("C", 6);
        Node nodeD = new Node("D", 9);
        Node nodeE = new Node("E", 7);
        Node nodeF = new Node("F", 10);
        Node nodeG = new Node("G", 8);
        Node nodeH = new Node("H", 0);
        Node nodeI = new Node("I", 3);
        Node nodeJ = new Node("J", 5);
        Node nodeK = new Node("K", 6);
        Node nodeL = new Node("L", 8);
        Node nodeM = new Node("M", 0);

        nodeA.addNeighbor(nodeB,1);
        nodeA.addNeighbor(nodeC,1);
        nodeB.addNeighbor(nodeE,1);
        nodeB.addNeighbor(nodeD,1);
        nodeE.addNeighbor(nodeJ,1);
        nodeE.addNeighbor(nodeI,1);
        nodeD.addNeighbor(nodeI,1);
        nodeD.addNeighbor(nodeH,1);
        nodeC.addNeighbor(nodeF,1);
        nodeC.addNeighbor(nodeG,1);
        nodeG.addNeighbor(nodeJ,1);
        nodeG.addNeighbor(nodeK,1);
        nodeK.addNeighbor(nodeL,1);
        nodeL.addNeighbor(nodeM,1);

        Node result = GreedyBFS.greedyBestFirstSearch(nodeA);
        Node result2 = AStarSearch.aStarSearch(nodeA);
        if (result == null) {
            System.out.println("No goal node found.");
        }

        TreeNode root = new TreeNode(true); // Root is a maximizer

        TreeNode level1Child1 = new TreeNode(false);
        TreeNode level1Child2 = new TreeNode(false);

        root.addChild(level1Child1);
        root.addChild(level1Child2);


        TreeNode leaf1 = new TreeNode(false); // Minimizer at the leaf level
        leaf1.setValue(3); // Leaf node with score
        TreeNode leaf2 = new TreeNode(false);
        leaf2.setValue(5);

        level1Child1.addChild(leaf1);
        level1Child1.addChild(leaf2);


        TreeNode intermediate = new TreeNode(true); // Maximizer intermediate node
        level1Child2.addChild(intermediate);
        TreeNode deepLeaf1 = new TreeNode(false);
        deepLeaf1.setValue(2);
        TreeNode deepLeaf2 = new TreeNode(false);
        deepLeaf2.setValue(9);
        intermediate.addChild(deepLeaf1);
        intermediate.addChild(deepLeaf2);


        int optimalValue = MinimaxAlgorithm.minimax(root, 0, root.isMaximizer);
        System.out.println("Optimal value calculated by Minimax: " + optimalValue);


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string with brackets: ");
        Stack stack = new Stack();
        String input = sc.nextLine();


        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if (token == '{') {
                stack.push(token);
            }
            else if(token == '}') {
                if (stack.isEmpty()) {
                    System.out.println("false");
                    return;
                }
                else {
                    stack.pop();
                }
            }
        }
        System.out.println(stack.isEmpty());

//{{{}}}



    }
}


