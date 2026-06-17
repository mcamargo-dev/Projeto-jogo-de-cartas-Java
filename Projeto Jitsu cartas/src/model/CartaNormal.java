package model;

import gerais.enums.Cor;
import gerais.enums.Elemento;
import gerais.enums.TipoEfeito;

public class CartaNormal extends Carta {
    public CartaNormal(int id, String nome, Elemento elemento, int numero, Cor cor) {
        super(id, nome, elemento, numero, cor, TipoEfeito.NENHUM);
    }

    @Override
    public void aplicarEfeito(Partida partida) {
    }
}
