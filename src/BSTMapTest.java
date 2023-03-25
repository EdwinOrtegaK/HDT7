import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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