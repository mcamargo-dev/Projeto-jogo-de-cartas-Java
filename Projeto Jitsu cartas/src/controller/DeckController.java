package controller;

import model.Carta;
import model.Deck;
import model.Jogador;
import gerais.repository.DeckRepository;
import view.DeckView;
import util.InputHelper;
import java.util.List;

public class DeckController {
    private DeckRepository repo;
    private DeckView view;

    public DeckController() {
        this.repo = new DeckRepository();
        this.view = new DeckView();
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.menuDecks();
            switch (opcao) {
                case 1 -> criarDeck(view.pedirId("Deck"));
                case 2 -> editarDeck(view.pedirId("Deck para editar"));
                case 3 -> excluirDeck(view.pedirId("Deck para excluir"));
                case 4 -> listarDecks();
                case 0 -> view.mensagens("Retornando ao Menu Principal...");
                default -> view.mensagens("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void criarDeck(int id) {
        String nome = InputHelper.lerTexto("Nome do deck: ");
        Jogador donoTemporario = new Jogador(999, "Jogador Associado");
        Deck d = new Deck(id, nome, donoTemporario);
        repo.salvar(d);
        view.mensagens("Deck criado com sucesso!");
    }

    public void editarDeck(int id) {
        Deck d = repo.buscarPorId(id);
        if (d == null) {
            view.mensagens("Deck não encontrado.");
            return;
        }
        String novoNome = InputHelper.lerTexto("Novo nome do deck: ");
        d.setNome(novoNome);
        repo.atualizar(d);
        view.mensagens("Deck atualizado com sucesso!");
    }

    public void excluirDeck(int id) {
        if (repo.buscarPorId(id) == null) {
            view.mensagens("Deck não encontrado.");
            return;
        }
        repo.excluir(id);
        view.mensagens("Deck excluído com sucesso!");
    }

    public List<Deck> listarDecks() {
        view.exibirLista(repo.listarTodos());
        return repo.listarTodos();
    }

    public void adicionarCarta(int dId, Carta c) {
        Deck d = repo.buscarPorId(dId);
        if (d != null && c != null) {
            d.adicionarCarta(c);
            repo.atualizar(d);
        }
    }

    public void removerCarta(int dId, int cId) {
        Deck d = repo.buscarPorId(dId);
        if (d != null) {
            d.getCartas().removeIf(c -> c.getId() == cId);
            repo.atualizar(d);
        }
    }
}