package dataStructure.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void insertTreeValue() throws Exception{
        Tree intTree = new Tree();

        for (int i = 0; i < 10; i++) {
            intTree.insert(i);
        }

        Assertions.assertTrue(intTree.containsNode(1));
    }



}