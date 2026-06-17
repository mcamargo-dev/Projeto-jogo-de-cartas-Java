package util;

import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(">>> Entrada inválida, tente novamente.");
            return lerInt(mensagem);
        }
    }
}
