package Controller;

import Model.Carta;
import Repository.CartaRepository;
import View.CartaView;

public class CartaController {
    private CartaRepository repository;
    private CartaView view;

    public CartaController(){
        this.repository = new CartaRepository();
        this.view = new CartaView();
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
