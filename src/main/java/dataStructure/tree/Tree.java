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

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {

        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        } else {

            // Cases 1 and 2 : node to delete  has 0 or 1 child(ren)
            if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();

            } else if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            }

            // Case 3 : node to delete has 2 children
            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }


        return subtreeRoot;
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
