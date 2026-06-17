package view;

import gerais.enums.Faixa;
import model.FaixaProgressao;
import util.InputHelper;

public class FaixaView {

    public int menuFaixas() {
        System.out.println("\n=== SISTEMA DE FAIXAS ===");
        System.out.println("1. Consultar Meu Progresso");
        System.out.println("2. Simular Ganho de Pontos");
        System.out.println("3. Listar Hierarquia de Faixas");
        System.out.println("0. Voltar");
        return InputHelper.lerInt("Escolha uma opção: ");
    }

    public void exibirProgresso(FaixaProgressao progressao) {
        System.out.println("\n--- PROGRESSO DO JOGADOR ---");
        System.out.println("Jogador: " + progressao.getJogador().getId());
        System.out.println("Faixa Atual: " + progressao.getFaixaAtual());
        System.out.println("Pontuação: " + progressao.getPontosAtuais() + " / " + progressao.getPontosProximoNivel());
        System.out.printf("Progresso até o próximo nível: %.2f%%\n", progressao.calcularProgresso());
    }

    public void exibirFaixas() {
        System.out.println("\n--- HIERARQUIA DE FAIXAS DO CARD-JITSU ---");
        for (Faixa f : Faixa.values()) {
            System.out.println("- Faixa " + f.name() + " (Nível " + (f.ordinal() + 1) + ")");
        }
    }

    public void mensagens(String mensagem) {
        System.out.println("[Faixa System] " + mensagem);
    }

    public int pedirPontos() {
        return InputHelper.lerInt("Digite a quantidade de pontos a adicionar: ");
    }

}
