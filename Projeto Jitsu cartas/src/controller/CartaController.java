package controller;

import model.Carta;
import gerais.repository.CartaRepository;
import view.CartaView;
import util.InputHelper;

public class CartaController {
    private CartaRepository repository;
    private CartaView view;

    public CartaController(){
        this.repository = new CartaRepository();
        this.view = new CartaView();
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.menuCartas();
            switch (opcao) {
                case 1:
                    cadastrarCarta();
                    break;
                case 2:
                    editarCarta(InputHelper.lerInt("Digite o ID da carta para editar: "));
                    break;
                case 3:
                    excluirCarta(InputHelper.lerInt("Digite o ID da carta para excluir: "));
                    break;
                case 4:
                    listarCartas();
                    break;
                case 5:
                    Carta c = buscarPorId(InputHelper.lerInt("Digite o ID da carta: "));
                    if (c != null) {
                        view.mensagens(c.toString());
                    }
                    break;
                case 0:
                    view.mensagens("Retornando ao Menu Principal...");
                    break;
                default:
                    view.mensagens("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void cadastrarCarta() {
        Carta carta = view.formCarta();
        repository.salvar(carta);
        view.mensagens("Carta cadastrada com sucesso!");
    }

    public void listarCartas() {
        view.exibirLista(repository.listarTodos());
    }

    public Carta buscarPorId(int id){
        Carta carta = repository.buscarPorId(id);
        if (carta == null){
            view.mensagens("Carta não encontrada.");
        }
        return carta;
    }

    public void excluirCarta(int id){
        Carta carta = repository.buscarPorId(id);
        if(carta == null) {
            view.mensagens("Carta não encontrada.");
            return;
        }
        repository.excluir(id);
        view.mensagens("Carta excluida com sucesso!");
    }

    public void editarCarta(int id){
        Carta cartaExistente = repository.buscarPorId(id);
        if (cartaExistente == null){
            view.mensagens("Carta não encontrada.");
            return;
        }
        view.mensagens("Digite os novos dados da carta: ");
        Carta cartaAtualizada = view.formCarta();
        cartaAtualizada.setId(id);
        repository.atualizar(cartaAtualizada);
        view.mensagens("Carta atualizada com sucesso!");
    }
}