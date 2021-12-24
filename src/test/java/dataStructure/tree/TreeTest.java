package dataStructure.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeTest {

    Tree intTree;

    @BeforeEach
    void setUp() {
        intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(22);
        intTree.insert(27);
        intTree.insert(26);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(32);
    }


    @Test
    void insertTreeValue() throws Exception {
        Tree tree = new Tree();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }
        System.out.println("tree = " + tree);
        Assertions.assertTrue(tree.containsNode(1));
    }


    @Test
    void printPreOrder() throws Exception {
        intTree.printPreOder();
    }

    @Test
    void printInOrder() throws Exception{
        intTree.traverseInorder();
    }

    @Test
    void postOrder() throws Exception{
        intTree.postOrder();
    }

}