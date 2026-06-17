package controller;

import gerais.enums.Faixa;
import model.Jogador;
import gerais.repository.JogadorRepository;
import view.JogadorView;
import util.InputHelper;
import java.util.List;

public class JogadorController {
    private JogadorRepository repo;
    private JogadorView view;

    public JogadorController() {
        this.repo = new JogadorRepository();
        this.view = new JogadorView();
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.menuJogadores();
            switch (opcao) {
                case 1 -> cadastrarJogador();
                case 2 -> editarJogador(InputHelper.lerInt("ID do jogador para editar: "));
                case 3 -> excluirJogador(InputHelper.lerInt("ID do jogador para excluir: "));
                case 4 -> listarJogadores();
                case 5 -> {
                    Jogador j = buscarPorId(InputHelper.lerInt("ID do jogador: "));
                    if (j != null) view.exibirDetalhes(j);
                    else view.mensagens("Jogador não encontrado.");
                }
                case 6 -> atualizarFaixa(InputHelper.lerInt("ID do jogador para atualizar faixa: "));
                case 0 -> view.mensagens("Retornando ao Menu Principal...");
                default -> view.mensagens("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void cadastrarJogador() {
        Jogador j = view.lerDados();
        repo.salvar(j);
        view.mensagens("Jogador cadastrado com sucesso!");
    }

    public void editarJogador(int id) {
        Jogador existente = repo.buscarPorId(id);
        if (existente == null) {
            view.mensagens("Jogador não encontrado.");
            return;
        }
        String novoNick = InputHelper.lerTexto("Novo Nickname: ");
        existente.setNickname(novoNick);
        repo.atualizar(existente);
        view.mensagens("Nickname atualizado com sucesso!");
    }

    public void excluirJogador(int id) {
        if (repo.buscarPorId(id) == null) {
            view.mensagens("Jogador não encontrado.");
            return;
        }
        repo.excluir(id);
        view.mensagens("Jogador excluído com sucesso!");
    }

    public List<Jogador> listarJogadores() {
        view.exibirLista(repo.listarTodos());
        return repo.listarTodos();
    }

    public Jogador buscarPorId(int id) {
        return repo.buscarPorId(id);
    }

    public void atualizarFaixa(int id) {
        Jogador j = repo.buscarPorId(id);
        if (j == null) {
            view.mensagens("Jogador não encontrado.");
            return;
        }
        Faixa novaFaixa = view.lerFaixa();
        j.setFaixa(novaFaixa);
        repo.atualizar(j);
        view.mensagens("Faixa atualizada com sucesso!");
    }
}