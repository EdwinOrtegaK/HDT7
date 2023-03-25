import org.junit.Test;

import java.security.Key;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class BSTMapTest {

    @org.junit.jupiter.api.Test
    public void findTest () {
        BSTMap Tree = new BSTMap();
        Tree.insert("apple", "manzana");

        TreeNode result = Tree.getHelper(Tree.getRoot(), "apple");
        assertNotNull(result);
    }

    @org.junit.jupiter.api.Test
    void insert() {
        BSTMap Tree = new BSTMap();
        Tree.insert("hello","hola");
        String esperado = "hola";
        String resultado = Tree.get("hello");
        assertEquals(esperado,resultado);
    }

    @org.junit.jupiter.api.Test
    void get() {
        BSTMap Tree = new BSTMap();
        Tree.insert("dog","perro");
        String esperado = "perro";
        String resultado = Tree.get("dog");
        assertEquals(esperado,resultado);
    }
}