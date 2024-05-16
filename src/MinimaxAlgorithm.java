public class MinimaxAlgorithm {
    public static class Result {
        int value;
        boolean pruningOccurred;

        public Result(int value, boolean pruningOccurred) {
            this.value = value;
            this.pruningOccurred = pruningOccurred;
        }
    }

    public static Result alphaBetaPruning(TreeNode node, int depth, int alpha, int beta, boolean isMaximizer) {
        if (node.children.isEmpty() || node.value != null) { // Base case: leaf node
            return new Result(node.value, false);
        }

        boolean pruningOccurred = false;

        if (isMaximizer) {
            int bestValue = Integer.MIN_VALUE;
            for (TreeNode child : node.children) {
                Result result = alphaBetaPruning(child, depth + 1, alpha, beta, false);
                bestValue = Math.max(bestValue, result.value);
                alpha = Math.max(alpha, bestValue);
                pruningOccurred = pruningOccurred || result.pruningOccurred;
                if (beta <= alpha) {
                    pruningOccurred = true;
                    break;
                }
            }
            return new Result(bestValue, pruningOccurred);
        } else {
            int bestValue = Integer.MAX_VALUE;
            for (TreeNode child : node.children) {
                Result result = alphaBetaPruning(child, depth + 1, alpha, beta, true);
                bestValue = Math.min(bestValue, result.value);
                beta = Math.min(beta, bestValue);
                pruningOccurred = pruningOccurred || result.pruningOccurred;
                if (beta <= alpha) {
                    pruningOccurred = true;
                    break;
                }
            }
            return new Result(bestValue, pruningOccurred);
        }
    }
}
