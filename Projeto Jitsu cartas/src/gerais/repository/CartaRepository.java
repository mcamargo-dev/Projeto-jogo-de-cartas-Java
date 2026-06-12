package Repository;
import Model.Carta;

import java.util.ArrayList;
import java.util.List;

public class CartaRepository {
    private List<Carta> cartas;

    public CartaRepository() {
        this.cartas = new ArrayList<>();
    }

    public void salvar(Carta carta){
        cartas.add(carta);
    }

    public void atualizar(Carta cartaAtualizada){

        for (int i = 0; i < cartas.size(); i++) {
            if (cartas.get(i).getId() == cartaAtualizada.getId()){
                cartas.set(i, cartaAtualizada);
                return;
            }
            
        }
    }

    public void excluir(int id){
        cartas.removeIf(carta -> carta.getId() == id);

    }

    public Carta buscarPorId(int id){
        for(Carta carta : cartas){
            if (carta.getId() == id){
                return carta;
            }
        }
        return null;
    }

    public List<Carta> listarTodos(){
        return cartas;
}
}
