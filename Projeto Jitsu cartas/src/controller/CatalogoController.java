package controller;

import model.Carta;
import model.CatalogoCartas;
import gerais.repository.CartaRepository;
import gerais.repository.CatalogoRepository;
import view.CatalogoView;
import util.InputHelper;

public class CatalogoController {

    private CatalogoRepository catalogoRepository;
    private CartaRepository cartaRepository;
    private CatalogoView view;

    public CatalogoController() {
        this.catalogoRepository = new CatalogoRepository();
        this.cartaRepository = new CartaRepository();
        this.view = new CatalogoView();
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.menuCatalogo();
            switch (opcao) {
                case 1:
                    int id = InputHelper.lerInt("ID do catálogo: ");
                    String nome = InputHelper.lerTexto("Nome do catálogo: ");
                    String descricao = InputHelper.lerTexto("Descrição do catálogo: ");
                    criarCatalogo(new CatalogoCartas(id, nome, descricao));
                    break;
                case 2:
                    int idCatAdd = InputHelper.lerInt("ID do catálogo: ");
                    int idCartaAdd = InputHelper.lerInt("ID da carta: ");
                    adicionarCarta(idCatAdd, idCartaAdd);
                    break;
                case 3:
                    int idCatRem = InputHelper.lerInt("ID do catálogo: ");
                    int idCartaRem = InputHelper.lerInt("ID da carta: ");
                    removerCarta(idCatRem, idCartaRem);
                    break;
                case 4:
                    listarCatalogos();
                    break;
                case 5:
                    int idBusca = InputHelper.lerInt("ID do catálogo: ");
                    CatalogoCartas cat = buscarCatalogo(idBusca);
                    if (cat != null) {
                        view.mensagens(cat.toString());
                        view.exibirCartas(cat.getCartas());
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