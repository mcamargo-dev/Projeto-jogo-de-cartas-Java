package model;

import gerais.enums.Cor;
import gerais.enums.Elemento;
import gerais.enums.TipoEfeito;

public abstract class Carta {
    protected int id;
    protected String nome;
    protected Elemento elemento;
    protected int numero;
    protected Cor cor;
    protected TipoEfeito tipoEfeito;

    public Carta(int id, String nome, Elemento elemento, int numero, Cor cor, TipoEfeito tipoEfeito) {
        this.id = id;
        this.nome = nome;
        this.elemento = elemento;
        this.numero = numero;
        this.cor = cor;
        this.tipoEfeito = tipoEfeito != null ? tipoEfeito : TipoEfeito.NENHUM;
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

    public TipoEfeito getTipoEfeito() { return tipoEfeito; }
    public void setTipoEfeito(TipoEfeito tipoEfeito) { this.tipoEfeito = tipoEfeito; }

    @Override
    public String toString() {
        String efeito = tipoEfeito != TipoEfeito.NENHUM ? " [" + tipoEfeito + "]" : "";
        return "[" + elemento + "] " + nome + " (" + numero + ")" + efeito; 
    }
}
