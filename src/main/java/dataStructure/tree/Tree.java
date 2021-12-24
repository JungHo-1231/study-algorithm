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
        root.preOrder(root);
    }

    public void traverseInorder(){
        root.inOrder(root);
    }

    public void postOrder(){
        root.postOrder(root);
    }

}
