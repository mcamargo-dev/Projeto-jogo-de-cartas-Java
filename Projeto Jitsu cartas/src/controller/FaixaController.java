package controller;

import model.FaixaProgressao;
import view.FaixaView;

public class FaixaController {

    private FaixaProgressao progressao;
    private FaixaView view;

    public FaixaController(FaixaProgressao progressao, FaixaView view) {
        this.progressao = progressao;
        this.view = view;
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.menuFaixas();
            switch (opcao) {
                case 1 -> consultarProgresso();
                case 2 -> {
                    int pts = view.pedirPontos();
                    atualizarPontos(pts);
                }
                case 3 -> view.exibirFaixas();
                case 0 -> view.mensagens("Retornando ao menu principal...");
                default -> view.mensagens("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void consultarProgresso() {
        view.exibirProgresso(progressao);
    }

    public void atualizarPontos(int pontos) {
        int pontosAntigos = progressao.getPontosAtuais();
        progressao.setPontosAtuais(pontosAntigos + pontos);
        view.mensagens("Foram adicionados " + pontos + " pontos ao jogador.");
        verificarPromocao();
    }

    public void verificarPromocao() {
        if (progressao.verificarPromocao()) {
            promoverJogador();
        }
    }

    public void promoverJogador() {
        String faixaAntiga = progressao.getFaixaAtual().name();
        progressao.promover();
        view.mensagens("🎉 PARABÉNS! Você subiu da Faixa " + faixaAntiga + " para a Faixa " + progressao.getFaixaAtual().name() + "! 🎉");
    }

}
