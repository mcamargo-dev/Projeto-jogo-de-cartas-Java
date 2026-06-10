package Util;

import java.util.Scanner;

public class InputHelper {

    public static Scanner scan = new Scanner(System.in);

    public static String lerTexto(String texto){
        System.out.print(texto);
        return scan.nextLine();
    }

    public static int lerInt(String texto){
        return Integer.parseInt(lerTexto(texto));
    }

    public static double lerDouble(String texto){
        return Double.parseDouble(lerTexto(texto));
    }

    public static float lerFloat(String texto){
        return Float.parseFloat(lerTexto(texto));
    }
}
