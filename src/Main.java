import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    static int op;
    // Se lleva a cabo el programa
    public static void main(String[] args) {
        BSTMap map = new BSTMap();

        System.out.println("===Bienvenido a tu Diccionario===");
        //Eleccion del idioma
        System.out.println("Qué idioma desea ingresar: \n1. Inglés\n2. Frances ");
        op = scan.nextInt();
        switch (op){
            case 1: //Ingles
                System.out.println("\n===Ordenar las palabras===");
                map.readFile("diccionario.txt",1);
                map.printInOr(map.getRoot());
                System.out.println("===Traducir la oracion===");
                System.out.println("La oración traducida es: ");
                ArrayList<String> TextOracioens = Reader.leer2();
                for (String ora : TextOracioens) {
                    String[] palabras = ora.split(" ");
                    StringBuilder traduccion = new StringBuilder();
                    for (String palabra : palabras) {
                        String traduccionPalabra = map.get(palabra);
                        traduccion.append(traduccionPalabra).append(" ");
                    }
                    System.out.println(traduccion.toString().trim());
                }
                break;
            case 2: //Frances
                System.out.println("\n===Ordenar las palabras===");
                map.readFile("diccionario.txt",2);
                map.printInOr(map.getRoot());
                System.out.println("===Traducir la oracion===");
                System.out.println("La oración traducida es: ");
                ArrayList<String> TextOraciones = Reader.leer2();
                for (String ora : TextOraciones) {
                    String[] palabras = ora.split(" ");
                    StringBuilder traduccion = new StringBuilder();
                    for (String palabra : palabras) {
                        String traduccionPalabra = map.get(palabra);
                        traduccion.append(traduccionPalabra).append(" ");
                    }
                    System.out.println(traduccion.toString().trim());
                }
                break;
        }
    }
}