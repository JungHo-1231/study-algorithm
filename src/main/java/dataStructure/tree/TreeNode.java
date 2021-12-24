package dataStructure.tree;


public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            return;
        }

        if (data < value) {
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }

        } else {
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(this, value);
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data
                ? containsNodeRecursive(current.rightChild, value)
                : containsNodeRecursive(current.leftChild, value);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

}
