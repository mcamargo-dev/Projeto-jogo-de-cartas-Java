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
        this.faixa = Faixa.BRANCA;
        this.decks = new ArrayList<>();
    }

    @Override
    public void resetarEstado() {}

    @Override
    public int getId() { return id; }
    public String getNickname() { return nickname; }

}
