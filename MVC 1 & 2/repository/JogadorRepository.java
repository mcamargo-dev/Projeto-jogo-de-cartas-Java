package repository;
import model.Jogador;
import java.util.ArrayList;
import java.util.List;

public class JogadorRepository {
    private List<Jogador> lista = new ArrayList<>();
    public void salvar(Jogador j) { lista.add(j); }
    public void atualizar(Jogador j) {}
    public void excluir(int id) { lista.removeIf(j -> j.getId() == id); }
    public Jogador buscarPorId(int id) { return null; }
    public List<Jogador> listarTodos() { return lista; }
}