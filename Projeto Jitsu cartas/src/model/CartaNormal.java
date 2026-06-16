package model;
import gerais.enums.Cor;
import gerais.enums.Elemento;

    public class CartaNormal extends Carta {

        public CartaNormal(int id, String nome, Elemento elemento, int numero, Cor cor){
        super(id, nome, elemento, numero, cor);
    }
    @Override
        public void aplicarEfeito(Partida partida){
            System.out.println("Carta normal não possui efeito adicional.");
    }
}
