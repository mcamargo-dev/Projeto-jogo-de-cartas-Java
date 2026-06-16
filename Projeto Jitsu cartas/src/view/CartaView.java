package view;

import gerais.enums.Cor;
import gerais.enums.Elemento;
import model.Carta;
import model.CartaEspecial;
import model.CartaNormal;

import java.util.List;
import java.util.Scanner;


public class CartaView {

    private Scanner scanner;

    public CartaView() {
        this.scanner = new Scanner(System.in);
    }

    public int menuCartas() {
        System.out.println("\n----- MENU CARTAS -----");
        System.out.println("1 - Cadastrar carta");
        System.out.println("2 - Editar carta");
        System.out.println("3 - Excluir carta");
        System.out.println("4 - Listar cartas");
        System.out.println("5 - Buscar carta por ID");
        System.out.println("0 - Voltar");

        System.out.print("Escolha uma opção: ");

        return scanner.nextInt();
    }

    public void exibirLista(List<Carta> cartas) {
        System.out.println("----- LISTA DE CARTAS -----");

        if (cartas.isEmpty()) {
            System.out.println("Nenhuma carta cadastrada.");
            return;
        }
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    public int escolherTipo() {
        System.out.println("----- TIPO DA CARTA -----");
        System.out.println("1 - Carta normal");
        System.out.println("2 - Carta especial");

        System.out.println("Escolha: ");

        return scanner.nextInt();
    }

    public void mensagens(String mensagem) {
        System.out.println(mensagem);

    }

    public Carta formCarta() {
        scanner.nextLine();

        System.out.println("----- CADASTRO DE CARTA -----");

        System.out.println("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Elemento disponível:");

        for (Elemento elemento : Elemento.values()) {
            System.out.println("- " + elemento);

        }

        System.out.println("Elemento: ");
        Elemento elemento = Elemento.valueOf(
                scanner.nextLine().toUpperCase()
        );

        System.out.println("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Cores disponíveis:");

        for (Cor cor : Cor.values()) {
            System.out.println("- " + cor);
        }

        System.out.println("Cor: ");
        Cor cor = Cor.valueOf(
                scanner.nextLine().toUpperCase()
        );

        int tipo = escolherTipo();
        if (tipo == 1) {

            return new CartaNormal(
                    id,
                    nome,
                    elemento,
                    numero,
                    cor
            );
        } else {

            System.out.println("Descrição do efeito: ");
            String descricao = scanner.nextLine();

            return new CartaEspecial(
                    id,
                    nome,
                    elemento,
                    numero,
                    cor,
                    descricao
            );

        }
    }
}
