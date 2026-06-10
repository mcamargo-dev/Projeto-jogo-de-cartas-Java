package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Deck implements Jogavel {
    private int id;
    private String nome;
    private List<Carta> cartas;
    private Jogador jogador;
    private LocalDate criadoEm;

    public Deck(int id, String nome, List<Carta> cartas, Jogador jogador, LocalDate criadoEm) {
        this.id = id;
        this.nome = nome;
        this.cartas = cartas;
        this.jogador = jogador;
        this.criadoEm = criadoEm;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    @Override public void resetarEstado() {}
    @Override public int getId() { return id; }
    // Adicione getters e setters
}
