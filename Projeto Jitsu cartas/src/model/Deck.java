package model;

import gerais.interfaces.Jogavel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Deck implements Jogavel {
    private int id;
    private String nome;
    private List<Carta> cartas;
    private Jogador jogador;
    private LocalDate criadoEm;

    public Deck(int id, String nome, Jogador jogador) {
        this.id = id;
        this.nome = nome;
        this.jogador = jogador;
        this.cartas = new ArrayList<>();
        this.criadoEm = LocalDate.now();
    }

    public void adicionarCarta(Carta carta) { this.cartas.add(carta); }
    public void removerCarta(Carta carta) { this.cartas.remove(carta); }
    public Carta obterCartaIndice(int indice) {
        if (indice >= 0 && indice < cartas.size()) {
            return cartas.get(indice);
        }
        return null;
    }
    public int getTamanho() { return cartas.size(); }

    @Override
    public void resetarEstado() { this.cartas.clear(); }

    // Getters e Setters
    @Override
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Carta> getCartas() { return cartas; }
    public void setCartas(List<Carta> cartas) { this.cartas = cartas; }

    public Jogador getJogador() { return jogador; }
    public void setJogador(Jogador jogador) { this.jogador = jogador; }

    public LocalDate getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDate criadoEm) { this.criadoEm = criadoEm; }

    @Override
    public String toString() {
        return nome + " (" + cartas.size() + " cartas)";
    }
}
