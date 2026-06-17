package model;

import gerais.enums.Cor;
import gerais.enums.Elemento;
import gerais.enums.TipoEfeito;

public class CartaEspecial extends Carta {
    private String descricaoEfeito;

    public CartaEspecial(int id, String nome, Elemento elemento, int numero, Cor cor, TipoEfeito efeito, String descricaoEfeito) {
        super(id, nome, elemento, numero, cor, efeito);
        this.descricaoEfeito = descricaoEfeito;
    }

    @Override
    public void aplicarEfeito(Partida partida) {
        try {
            System.out.println("\n✦ Efeito Ativado: " + descricaoEfeito);
            
            switch (this.tipoEfeito) {
                case DOBRO_FORCA:
                    this.numero *= 2;
                    System.out.println("→ Força da carta DOBRADA para: " + this.numero);
                    break;
                case MEIA_FORCA:
                    this.numero = Math.max(1, this.numero / 2);
                    System.out.println("→ Força reduzida para: " + this.numero);
                    break;
                default:
                    System.out.println("→ Efeito especial aplicado");
            }
        } catch (Exception e) {
            System.err.println("Erro ao aplicar efeito: " + e.getMessage());
        }
    }

    public String getDescricaoEfeito() { return descricaoEfeito; }
    public void setDescricaoEfeito(String descricaoEfeito) { this.descricaoEfeito = descricaoEfeito; }
}
