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

        nodeA.addNeighbor(nodeB, 1, false);
        nodeA.addNeighbor(nodeC, 1, false);
        nodeB.addNeighbor(nodeE, 1, false);
        nodeB.addNeighbor(nodeD, 1, false);
        nodeE.addNeighbor(nodeJ, 1, false);
        nodeE.addNeighbor(nodeI, 1, false);
        nodeD.addNeighbor(nodeI, 1, false);
        nodeD.addNeighbor(nodeH, 1, false);
        nodeC.addNeighbor(nodeF, 1, false);
        nodeC.addNeighbor(nodeG, 1, false);
        nodeG.addNeighbor(nodeJ, 1, false);
        nodeG.addNeighbor(nodeK, 1, false);
        nodeK.addNeighbor(nodeL, 1, false);
        nodeL.addNeighbor(nodeM, 1, false);

        Node result = GreedyBFS.greedyBestFirstSearch(nodeA);
        Node result2 = AStarSearch.aStarSearch(nodeA);
        if (result == null || result2 == null) {
            System.out.println("No goal node found.");
        }


        TreeNode root2 = new TreeNode(true);

        TreeNode c1 = new TreeNode(false);
        TreeNode c2 = new TreeNode(false);

        root2.addChild(c1);
        root2.addChild(c2);


        TreeNode c11 = new TreeNode(true);
        TreeNode c12 = new TreeNode(true);

        c1.addChild(c11);
        c1.addChild(c12);

        TreeNode c111 = new TreeNode(10);
        TreeNode c112 = new TreeNode(5);
        TreeNode c121 = new TreeNode(7);
        TreeNode c122 = new TreeNode(11);

        c11.addChild(c111);
        c11.addChild(c112);
        c12.addChild(c121);
        c12.addChild(c122);


        TreeNode c21 = new TreeNode(true);
        TreeNode c22 = new TreeNode(true);

        c2.addChild(c11);
        c2.addChild(c12);

        TreeNode c211 = new TreeNode(5);
        TreeNode c212 = new TreeNode(12);
        TreeNode c221 = new TreeNode(11);
        TreeNode c222 = new TreeNode(12);

        c21.addChild(c211);
        c21.addChild(c212);
        c22.addChild(c221);
        c22.addChild(c222);
/*
           (root2, Max)
           /          \
     (c1, Min)          (c2, Min)
    /    \                  /    \
(c11, Max) (c12, Max)  (c21, Max) (c22, Max)
 /    \     /    \     /    \     /    \
[10]  [5]  [7]  [11]  [5]  [12]  [11]  [12]
*/



        MinimaxAlgorithm.Result result4 = MinimaxAlgorithm.alphaBetaPruning(root2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        System.out.println("Best value: " + result4.value);
        System.out.println("Pruning occurred: " + result4.pruningOccurred);






    }

}


