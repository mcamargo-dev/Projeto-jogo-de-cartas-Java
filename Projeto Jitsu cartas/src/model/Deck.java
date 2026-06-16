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
    }
    @Override public void resetarEstado() {}
    @Override public int getId() { return id; }
    // Adicione getters e setters
}
