import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    static int op;

    public static void main(String[] args) {
        BSTMap map = new BSTMap();

        System.out.println("===Bienvenido a tu Diccionario===");
        System.out.println("Qué idioma desea ingresar: \n1. Inglés\n2. Frances ");
        op = scan.nextInt();
        switch (op){
            case 1: //Ingles
                map.readFile("diccionario.txt",1);
                break;
            case 2: //Frances
                map.readFile("diccionario.txt",2);
                break;
        }
    }
}