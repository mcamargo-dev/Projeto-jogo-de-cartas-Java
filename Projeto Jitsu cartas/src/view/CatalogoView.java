package View;

import Model.Carta;
import Model.CatalogoCartas;

import java.util.List;
import java.util.Scanner;

public class CatalogoView {

    private Scanner scanner;

    public CatalogoView() {
        this.scanner = new Scanner(System.in);
    }

    public int menuCatalogo() {

        System.out.println("\n----- MENU CATÁLOGO -----");
        System.out.println("1 - Criar catálogo");
        System.out.println("2 - Adicionar carta ao catálogo");
        System.out.println("3 - Remover carta do catálogo");
        System.out.println("4 - Listar catálogos");
        System.out.println("5 - Buscar catálogo por ID");
        System.out.println("0 - Voltar");

        System.out.print("Escolha uma opção: ");

        return scanner.nextInt();
    }

    public void exibirCatalogos(List<CatalogoCartas> catalogos) {

        System.out.println("\n----- CATÁLOGOS -----");

        if (catalogos.isEmpty()) {

            System.out.println("Nenhum catálogo cadastrado.");
            return;
        }

        for (CatalogoCartas catalogo : catalogos) {

            System.out.println(catalogo);
        }
    }

    public void exibirCartas(List<Carta> cartas) {

        System.out.println("\n----- CARTAS DO CATÁLOGO -----");

        if (cartas.isEmpty()) {

            System.out.println("Nenhuma carta encontrada.");
            return;
        }

        for (Carta carta : cartas) {

            System.out.println(carta);
        }
    }

    public void mensagens(String mensagem) {

        System.out.println(mensagem);

    }
}