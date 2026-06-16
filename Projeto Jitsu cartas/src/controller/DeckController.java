package controller;
import model.Carta;
import model.Deck;
import model.Jogador;
import gerais.repository.DeckRepository;
import java.util.List;

public class DeckController {
    private DeckRepository repo = new DeckRepository();
    public void criarDeck(int id, String n, Jogador j) { repo.salvar(new Deck(id, n, j)); }
    public void editarDeck(int id, String n) {}
    public void excluirDeck(int id) { repo.excluir(id); }
    public List<Deck> listarDecks() { return repo.listarTodos(); }
    public void adicionarCarta(int dId, Carta c) {}
    public void removerCarta(int dId, int cId) {}
}