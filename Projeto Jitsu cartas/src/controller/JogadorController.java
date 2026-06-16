package controller;
import gerais.enums.Faixa;
import model.Jogador;
import gerais.repository.JogadorRepository;
import java.util.List;

public class JogadorController {
    private JogadorRepository repo = new JogadorRepository();
    public void cadastrarJogador(int id, String n) { repo.salvar(new Jogador(id, n)); }
    public void editarJogador(int id, String n) {}
    public void excluirJogador(int id) { repo.excluir(id); }
    public List<Jogador> listarJogadores() { return repo.listarTodos(); }
    public Jogador buscarPorId(int id) { return repo.buscarPorId(id); }
    public void atualizarFaixa(int id, Faixa f) {}
}