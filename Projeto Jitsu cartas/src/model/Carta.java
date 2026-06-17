package model;

import gerais.enums.Cor;
import gerais.enums.Elemento;

public abstract class Carta {
    private int id;
    private String nome;
    private Elemento elemento;
    private int numero;
    private Cor cor;

    public Carta(int id, String nome, Elemento elemento, int numero, Cor cor) {
        this.id = id;
        this.nome = nome;
        this.elemento = elemento;
        this.numero = numero;
        this.cor = cor;
    }

    public abstract void aplicarEfeito(Partida partida);

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Elemento getElemento() { return elemento; }
    public void setElemento(Elemento elemento) { this.elemento = elemento; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public Cor getCor() { return cor; }
    public void setCor(Cor cor) { this.cor = cor; }

    @Override
    public String toString() {
        return "[" + elemento + "] " + nome + " (" + numero + ")"; 
    }
}
