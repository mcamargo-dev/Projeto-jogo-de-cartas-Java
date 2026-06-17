package gerais.repository;

import model.Deck;
import java.util.ArrayList;
import java.util.List;

public class DeckRepository {
    private List<Deck> lista = new ArrayList<>();

    public void salvar(Deck d) {
        lista.add(d);
    }

    public void atualizar(Deck dAtualizado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == dAtualizado.getId()) {
                lista.set(i, dAtualizado);
                return;
            }
        }
    }

    public void excluir(int id) {
        lista.removeIf(d -> d.getId() == id);
    }

    public Deck buscarPorId(int id) {
        for (Deck d : lista) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public List<Deck> listarTodos() {
        return lista;
    }
}