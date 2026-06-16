package gerais.repository;
import model.Deck;
import java.util.ArrayList;
import java.util.List;

public class DeckRepository {
    private List<Deck> lista = new ArrayList<>();
    public void salvar(Deck d) { lista.add(d); }
    public void atualizar(Deck d) {}
    public void excluir(int id) { lista.removeIf(d -> d.getId() == id); }
    public Deck buscarPorId(int id) { return null; }
    public List<Deck> listarTodos() { return lista; }
}