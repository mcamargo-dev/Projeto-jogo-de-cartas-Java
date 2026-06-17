package model;

import java.util.ArrayList;
import java.util.List;
import gerais.enums.Faixa;
import gerais.interfaces.Jogavel;

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
        this.vitorias = 0;
        this.derrotas = 0;
        this.faixa = Faixa.BRANCA;
        this.decks = new ArrayList<>();
    }

    @Override
    public void resetarEstado() {
        this.vitorias = 0;
        this.derrotas = 0;
        this.faixa = Faixa.BRANCA;
    }

    public void incrementarVitorias() { this.vitorias++; }
    public void incrementarDerrotas() { this.derrotas++; }

    public void adicionarDeck(Deck deck) { this.decks.add(deck); }
    public void removerDeck(Deck deck) { this.decks.remove(deck); }

    // Getters e Setters
    @Override
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public int getVitorias() { return vitorias; }
    public void setVitorias(int vitorias) { this.vitorias = vitorias; }

    public int getDerrotas() { return derrotas; }
    public void setDerrotas(int derrotas) { this.derrotas = derrotas; }

    public Faixa getFaixa() { return faixa; }
    public void setFaixa(Faixa faixa) { this.faixa = faixa; }

    public List<Deck> getDecks() { return decks; }
    public void setDecks(List<Deck> decks) { this.decks = decks; }

    @Override
    public String toString() {
        return nickname + " [" + vitorias + "V-" + derrotas + "D] " + faixa;
    }
}
