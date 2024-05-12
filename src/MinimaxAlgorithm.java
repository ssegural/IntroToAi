public class MinimaxAlgorithm {

    public static int minimax(TreeNode node, int depth, boolean isMaximizer) {
        if (node.children.isEmpty() || node.value != null) { // Base case: leaf node
            return node.value;
        }

        if (isMaximizer) {
            int bestValue = Integer.MIN_VALUE;
            for (TreeNode child : node.children) {
                bestValue = Math.max(bestValue, minimax(child, depth + 1, !child.isMaximizer));
            }
            return bestValue;
        } else {
            int bestValue = Integer.MAX_VALUE;
            for (TreeNode child : node.children) {
                bestValue = Math.min(bestValue, minimax(child, depth + 1, !child.isMaximizer));
            }
            return bestValue;
        }
    }

}