package view;

import model.Deck;
import model.Jogador;
import util.InputHelper;
import java.util.List;

public class DeckView {

    public int menuDecks() {
        System.out.println("\n----- MENU DECKS -----");
        System.out.println("1 - Criar deck vazio");
        System.out.println("2 - Editar nome do deck");
        System.out.println("3 - Excluir deck");
        System.out.println("4 - Listar decks");
        System.out.println("0 - Voltar");
        return InputHelper.lerInt("Escolha uma opção: ");
    }

    public void exibirLista(List<Deck> l) {
        System.out.println("\n----- LISTA DE DECKS -----");
        if (l.isEmpty()) {
            System.out.println("Nenhum deck cadastrado.");
            return;
        }
        for (Deck d : l) {
            System.out.println(d);
        }
    }

    public Deck formDeck(Jogador dono) {
        System.out.println("\n----- NOVO DECK -----");
        int id = InputHelper.lerInt("ID: ");
        String nome = InputHelper.lerTexto("Nome do Deck: ");
        return new Deck(id, nome, dono);
    }

    public int pedirId(String item) {
        return InputHelper.lerInt("Digite o ID do " + item + ": ");
    }

    public void mensagens(String m) {
        System.out.println(m);
    }
}