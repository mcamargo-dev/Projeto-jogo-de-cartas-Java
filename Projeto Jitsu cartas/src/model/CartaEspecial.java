package model;

import gerais.enums.Cor;
import gerais.enums.Elemento;

public class CartaEspecial extends Carta {
    private String descricaoEfeito;

    public CartaEspecial(int id, String nome, Elemento elemento, int numero, Cor cor, String descricaoEfeito) {
        super(id, nome, elemento, numero, cor);
        this.descricaoEfeito = descricaoEfeito;
    }

    @Override
    public void aplicarEfeito(Partida partida) {
        System.out.println("✦ Efeito Especial: " + descricaoEfeito);
    }

    public String getDescricaoEfeito() { return descricaoEfeito; }
    public void setDescricaoEfeito(String descricaoEfeito) { this.descricaoEfeito = descricaoEfeito; }
}
