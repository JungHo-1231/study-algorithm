package dataStructure.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    public static final int MINVALUE = 15;
    public static final int MAXVALUE = 32;
    Tree intTree;
    private int value;

    @BeforeEach
    void setUp() {
        intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(MINVALUE);
        intTree.insert(22);
        intTree.insert(27);
        intTree.insert(26);
        intTree.insert(30);
        intTree.insert(value);
        intTree.insert(MAXVALUE);
    }


    @Test
    void insertTreeValue() throws Exception {
        Tree tree = new Tree();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }
        System.out.println("tree = " + tree);
        assertTrue(tree.containsNode(1));
    }


    @Test
    void printPreOrder() throws Exception {
        intTree.printPreOder();
    }

    @Test
    void printInOrder() throws Exception {
        intTree.traverseInorder();
    }

    @Test
    void postOrder() throws Exception {
        intTree.traversePostOrder();
    }

    @Test
    void get() throws Exception {
        TreeNode treeNode = intTree.get(32);
        assertEquals(treeNode.getData(), 32);
    }

    @Test
    void min() throws Exception {
        int min = intTree.min();
        assertEquals(min, MINVALUE);
    }

    @Test
    void max() throws Exception {
        int max = intTree.max();
        assertEquals(max, MAXVALUE);
    }

}