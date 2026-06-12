package Controller;

import Model.Carta;
import Model.CatalogoCartas;
import Repository.CartaRepository;
import Repository.CatalogoRepository;
import View.CatalogoView;

public class CatalogoController {

    private CatalogoRepository catalogoRepository;
    private CartaRepository cartaRepository;
    private CatalogoView view;

    public CatalogoController() {
        this.catalogoRepository = new CatalogoRepository();
        this.cartaRepository = new CartaRepository();
        this.view = new CatalogoView();
    }

    public void criarCatalogo(CatalogoCartas catalogo) {

        catalogoRepository.salvar(catalogo);

        view.mensagens("Catálogo criado com sucesso!");

    }

    public void listarCatalogos() {

        view.exibirCatalogos(catalogoRepository.listarTodos());

    }

    public CatalogoCartas buscarCatalogo(int id) {

        CatalogoCartas catalogo = catalogoRepository.buscarPorId(id);

        if (catalogo == null) {

            view.mensagens("Catálogo não encontrado.");

        }

        return catalogo;
    }

    public void adicionarCarta(int idCatalogo, int idCarta) {

        CatalogoCartas catalogo = catalogoRepository.buscarPorId(idCatalogo);

        if (catalogo == null) {

            view.mensagens("Catálogo não encontrado.");
            return;
        }

        Carta carta = cartaRepository.buscarPorId(idCarta);

        if (carta == null) {

            view.mensagens("Carta não encontrada.");
            return;
        }

        catalogo.getCartas().add(carta);

        catalogoRepository.atualizar(catalogo);

        view.mensagens("Carta adicionada ao catálogo com sucesso!");
    }

    public void removerCarta(int idCatalogo, int idCarta) {

        CatalogoCartas catalogo = catalogoRepository.buscarPorId(idCatalogo);

        if (catalogo == null) {

            view.mensagens("Catálogo não encontrado.");
            return;
        }

        boolean removida = catalogo.getCartas().removeIf(
                carta -> carta.getId() == idCarta
        );

        if (!removida) {

            view.mensagens("Carta não encontrada no catálogo.");
            return;
        }

        catalogoRepository.atualizar(catalogo);

        view.mensagens("Carta removida do catálogo com sucesso!");
    }


}