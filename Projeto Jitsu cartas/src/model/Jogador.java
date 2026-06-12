package model;
import java.util.ArrayList;
import java.util.List;

public class Jogador implements Jogavel {
    private int id;
    private String nickname;
    private int vitorias;
    private int derrotas;
    private Faixa faixa;
    private List<Deck> decks;

    public Jogador(int id, String nickname) {
        this.id = id;
        this.nickname = nickname;
        this.decks = new ArrayList<>();
    }
    @Override public void resetarEstado() {}
    @Override public int getId() { return id; }
    // Adicione getters e setters
}