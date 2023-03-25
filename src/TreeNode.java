public class TreeNode {
    public String key;
    public String value;
    public TreeNode left;
    public TreeNode right;

    /**
     * Clase de arbol binario
     * @param key
     * @param value
     */
    public TreeNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
