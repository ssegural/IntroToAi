import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    Integer value;
    List<TreeNode> children;
    boolean isMaximizer;

    public TreeNode(boolean isMaximizer) {
        this.isMaximizer = isMaximizer;
        this.children = new ArrayList<>();
        this.value = null;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void setValue(int value) {
        this.value = value;
    }
}

