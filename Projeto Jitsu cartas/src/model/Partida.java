package model;

import gerais.interfaces.Jogavel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Jogavel {

    private int id;
    private Jogador jogador1;
    private Jogador jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private List<Carta> cartasMesa;
    private Jogador vencedor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Partida(int id, Jogador jogador1, Jogador jogador2, Deck deckJogador1, Deck deckJogador2) {
        this.id = id;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.cartasMesa = new ArrayList<>();
        this.dataInicio = LocalDateTime.now();
    }

    public void iniciar() {
        System.out.println("Partida " + id + " iniciada!");
    }

    public void jogarRodada() {
    }

    public void definirVencedor(Jogador jogador) {
        this.vencedor = jogador;
        this.dataFim = LocalDateTime.now();
    }

    public boolean verificarVitoria(Jogador p) {
        return false;
    }

    @Override
    public void resetarEstado() {
        this.cartasMesa.clear();
        this.vencedor = null;
        this.dataFim = null;
    }

    @Override
    public int getId() {
        return id;
    }
    
    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Deck getDeckJogador1() {
        return deckJogador1;
    }

    public void setDeckJogador1(Deck deckJogador1) {
        this.deckJogador1 = deckJogador1;
    }

    public Deck getDeckJogador2() {
        return deckJogador2;
    }

    public void setDeckJogador2(Deck deckJogador2) {
        this.deckJogador2 = deckJogador2;
    }

    public List<Carta> getCartasMesa() {
        return cartasMesa;
    }

    public void setCartasMesa(List<Carta> cartasMesa) {
        this.cartasMesa = cartasMesa;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
}