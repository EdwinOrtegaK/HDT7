import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BSTMap {
    private TreeNode root;

    public BSTMap() {
        this.root = null;
    }

    public void insert(String key, String value) {
        this.root = insertHelper(this.root, key, value);
    }

    private TreeNode insertHelper(TreeNode node, String key, String value) {
        if (node == null) {
            return new TreeNode(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = insertHelper(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertHelper(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public String get(String key) {
        TreeNode node = getHelper(this.root, key);
        if (node != null) {
            return node.value;
        } else {
            return null;
        }
    }

    private TreeNode getHelper(TreeNode node, String key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getHelper(node.left, key);
        } else {
            return getHelper(node.right, key);
        }
    }

    public void remove(String key) {
        this.root = removeHelper(this.root, key);
    }

    private TreeNode removeHelper(TreeNode node, String key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = removeHelper(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = removeHelper(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                TreeNode successor = findMin(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = removeHelper(node.right, successor.key);
            }
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void readFile(String rutaArchivo, int param) {

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] palabra = linea.split(",");
                if (palabra.length != 3) {
                    System.out.println("La línea \"" + linea + "\" debe contener 3 palabras separadas por comas");
                    continue;
                }

                String key, value;
                if (param == 1) {
                    key = palabra[0];
                    value = palabra[1];
                } else if (param == 2) {
                    key = palabra[2];
                    value = palabra[1];
                } else {
                    System.out.println("El parámetro debe ser 1 o 3");
                    return;
                }
                insert(key, value);
            }
        } catch (IOException e) {
            return;
        }

    }
}
