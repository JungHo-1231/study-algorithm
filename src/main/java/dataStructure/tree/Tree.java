package dataStructure.tree;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public boolean containsNode(int value) {
        return root.containsNode(value);
    }

    public void printPreOder() {
        root.traversePreOder();
    }

    public void traverseInorder() {
        root.traverseInorder();
    }

    public void traversePostOrder() {
        root.traversePostOrder();
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }


    public int min() {
        if (root != null) {
            return root.min();
        }
        return 0;
    }

    public int max() {
        if (root != null) {
            return root.max();
        }
        return 0;
    }
}
