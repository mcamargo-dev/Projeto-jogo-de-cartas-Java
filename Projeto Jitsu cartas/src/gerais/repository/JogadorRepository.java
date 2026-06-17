package gerais.repository;

import model.Jogador;
import java.util.ArrayList;
import java.util.List;

public class JogadorRepository {
    private List<Jogador> lista = new ArrayList<>();

    public void salvar(Jogador j) {
        lista.add(j);
    }

    public void atualizar(Jogador jAtualizado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == jAtualizado.getId()) {
                lista.set(i, jAtualizado);
                return;
            }
        }
    }

    public void excluir(int id) {
        lista.removeIf(j -> j.getId() == id);
    }

    public Jogador buscarPorId(int id) {
        for (Jogador j : lista) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }

    public List<Jogador> listarTodos() {
        return lista;
    }
}