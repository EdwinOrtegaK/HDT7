import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BSTMap {
    public TreeNode getRoot() {
        return root;
    }

    private TreeNode root;

    public BSTMap() {
        this.root = null;
    }

    /**
     * Agrega una nueva palabra al diccionario
     * @param key
     * @param value
     */
    public void insert(String key, String value) {
        this.root = insertHelper(this.root, key, value);
    }

    /**
     * Ayuda a agregar una nueva palabra al diccionario
     * @param node
     * @param key
     * @param value
     * @return
     */
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

    /**
     * Traduce las palabras
     * @param key
     * @return
     */
    public String get(String key) {
        TreeNode node = getHelper(this.root, key);
        if (node != null) {
            return node.value;
        } else {
            return "*"+key+"*";
        }
    }

    /**
     * Ayuda a traducir las palabras
     * @param node
     * @param key
     * @return
     */
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

    /**
     * Lee el archivo que contiene las palabaras y su tarduccion
     * @param rutaArchivo
     * @param param
     */
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

    /**
     * Ayuda a ordenar
     * @param node
     */
    public void printInOr(TreeNode node) {
        if (node != null) {
            printInOr(node.left);
            System.out.print("(" + node.key + ", " + node.value + ") ");
            printInOr(node.right);
        }
    }
}
