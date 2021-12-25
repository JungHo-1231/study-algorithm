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

    public void traversePreOder() {
        System.out.println(this.data);

        if (leftChild != null) {
            leftChild.traversePreOder();
        }
        if (rightChild != null) {
            rightChild.traversePreOder();
        }
    }

    public void traverseInorder() {
        if (leftChild != null) {
            leftChild.traverseInorder();
        }
        System.out.println(data);

        if (rightChild != null) {
            rightChild.traverseInorder();
        }
    }


    public void traversePostOrder() {

        if (leftChild != null) {
            leftChild.traversePostOrder();
        }

        if (rightChild != null) {
            rightChild.traversePostOrder();
        }

        System.out.println(this.data);
    }

    public TreeNode get(int value) {
        if (this.data == value) {
            return this;
        }

        if (data > value) {
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        return null;
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

    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }
}
