package model;

import java.util.ArrayList;
import java.util.List;

public class CatalogoCartas {
    private int id;
    private String nome;
    private String descricao;
    private List<Carta> cartas;

    public CatalogoCartas() {
        this.cartas = new ArrayList<>();
    }

    public CatalogoCartas(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cartas = new ArrayList<>();
    }

    public void adicionarCarta(Carta carta) { this.cartas.add(carta); }
    public List<Carta> listarCartas() { return new ArrayList<>(this.cartas); }
    public int getTotalCartas() { return cartas.size(); }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public List<Carta> getCartas() { return cartas; }
    public void setCartas(List<Carta> cartas) { this.cartas = cartas; }

    @Override
    public String toString() {
        return nome + " - " + getTotalCartas() + " cartas";
    }
}
