import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    List<TreeNode> children;
    boolean isMaximizer;
    Integer value;

    public TreeNode(boolean isMaximizer) {
        this.isMaximizer = isMaximizer;
        this.children = new ArrayList<>();
        this.value = null;
    }

    public TreeNode(int value) {
        this.isMaximizer = false; // Leaf nodes are just ints
        this.children = new ArrayList<>();
        this.value = value;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void setValue(int value) {
        this.value = value;
    }
}
