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

    public Jogador(int id, String nickname, int vitorias, int derrotas, Faixa faixa, List<Deck> decks) {
        this.id = id;
        this.nickname = nickname;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.faixa = faixa;
        this.decks = decks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public Faixa getFaixa() {
        return faixa;
    }

    public void setFaixa(Faixa faixa) {
        this.faixa = faixa;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    @Override public void resetarEstado() {}
    @Override public int getId() { return id; }
    // Adicione getters e setters
}