package controller;

import model.EfeitoEspecial;
import view.EfeitoEspecialView;
import gerais.enums.TipoEfeito;

import java.util.ArrayList;
import java.util.List;

public class EfeitoEspecialController {

    private List<EfeitoEspecial> bancoDadosEfeitos = new ArrayList<>();
    private EfeitoEspecialView view;
    private int geradorId = 1;

    public EfeitoEspecialController(EfeitoEspecialView view) {
        this.view = view;
        bancoDadosEfeitos.add(new EfeitoEspecial(geradorId++, "Força Dupla", "Dobra a força da carta", TipoEfeito.DOBRO_FORCA));
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.menuEfeitos();
            switch (opcao) {
                case 1 -> criarEfeito();
                case 2 -> editarEfeito();
                case 3 -> excluirEfeito();
                case 4 -> listarEfeitos();
                case 0 -> view.mensagens("Retornando ao menu de configurações...");
                default -> view.mensagens("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void criarEfeito() {
        EfeitoEspecial novo = view.formEfeito(geradorId++);
        bancoDadosEfeitos.add(novo);
        view.mensagens("Efeito '" + novo.getNome() + "' criado com sucesso!");
    }

    public void editarEfeito() {
        int id = view.pedirId("editar");
        EfeitoEspecial encontrado = buscarPorId(id);
        if (encontrado != null) {
            EfeitoEspecial dadosNovos = view.formEfeito(id);
            encontrado.setNome(dadosNovos.getNome());
            encontrado.setDescricao(dadosNovos.getDescricao());
            encontrado.setTipoEfeito(dadosNovos.getTipoEfeito());
            view.mensagens("Efeito ID " + id + " atualizado com sucesso.");
        } else {
            view.mensagens("Erro: Efeito com ID " + id + " não encontrado.");
        }
    }

    public void excluirEfeito() {
        int id = view.pedirId("excluir");
        EfeitoEspecial encontrado = buscarPorId(id);
        if (encontrado != null) {
            bancoDadosEfeitos.remove(encontrado);
            view.mensagens("Efeito ID " + id + " removido com sucesso.");
        } else {
            view.mensagens("Erro: Efeito com ID " + id + " não foi localizado.");
        }
    }

    public void listarEfeitos() {
        view.exibirLista(bancoDadosEfeitos);
    }

    private EfeitoEspecial buscarPorId(int id) {
        return bancoDadosEfeitos.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}