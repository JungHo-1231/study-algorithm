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

        if (data > value) {
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
                ? containsNodeRecursive(current.leftChild, value)
                : containsNodeRecursive(current.rightChild, value);
    }

    public void preOrder(TreeNode node) {
        System.out.println(node.data);

        if (node.leftChild != null) {
            preOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            preOrder(node.rightChild);
        }
    }

    public void inOrder(TreeNode node) {

        if (node.leftChild != null) {
            inOrder(node.leftChild);
        }

        System.out.println(node.data);

        if (node.rightChild != null) {
            inOrder(node.rightChild);
        }
    }


    public void postOrder(TreeNode node) {

        if (node.leftChild != null) {
            postOrder(node.leftChild);
        }

        if (node.rightChild != null) {
            postOrder(node.rightChild);
        }

        System.out.println(node.data);
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
