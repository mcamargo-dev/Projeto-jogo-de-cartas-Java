package view;

import controller.PartidaController;
import model.Jogador;
import model.Carta;
import util.InputHelper;

import java.util.List;

public class PartidaView {

    private PartidaController controller;

    public PartidaView() {
        this.controller = new PartidaController();
    }

    public void menuPartida() {
        int opcao;
        do {
            System.out.println("\n--- MENU PARTIDA ---");
            System.out.println("1. Iniciar nova partida");
            System.out.println("2. Jogar rodada");
            System.out.println("3. Exibir estado da partida");
            System.out.println("4. Exibir mesa");
            System.out.println("0. Encerrar partida");
            opcao = InputHelper.lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    mensagens("A inicializacao da partida deve receber os objetos via Controller.");
                    break;
                case 2:
                    controller.jogarRodada();
                    mensagens("Processamento da rodada concluido.");
                    break;
                case 3:
                    exibirEstado();
                    break;
                case 4:
                    if (controller.getPartidaAtual() != null) {
                        exibirMesa(controller.getPartidaAtual().getCartasMesa());
                    } else {
                        mensagens("Nenhuma partida em andamento para exibir a mesa.");
                    }
                    break;
                case 0:
                    mensagens("Saindo do menu de partida.");
                    break;
                default:
                    mensagens("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    public void exibirEstado() {
        if (controller.getPartidaAtual() != null) {
            System.out.println("\n--- ESTADO DA PARTIDA ---");
            System.out.println("Partida ID: " + controller.getPartidaAtual().getId());
            System.out.println("Jogador 1: " + controller.getPartidaAtual().getJogador1().getNickname());
            System.out.println("Jogador 2: " + controller.getPartidaAtual().getJogador2().getNickname());
            System.out.println("Inicio: " + controller.getPartidaAtual().getDataInicio());
        } else {
            mensagens("Nenhuma partida em andamento.");
        }
    }

    public void exibirMesa(List<Carta> cartasMesa) {
        if (cartasMesa == null || cartasMesa.isEmpty()) {
            mensagens("A mesa esta vazia.");
            return;
        }
        System.out.println("\n--- CARTAS NA MESA ---");
        for (Carta carta : cartasMesa) {
            System.out.println(carta.toString());
        }
    }

    public int lerJogada(Jogador jogador) {
        System.out.println("\nTurno de: " + jogador.getNickname());
        return InputHelper.lerInt("Digite o indice da carta que deseja jogar: ");
    }

    public void exibirVencedor(Jogador vencedor) {
        System.out.println("\n==================================");
        if (vencedor != null) {
            System.out.println("   VENCEDOR: " + vencedor.getNickname().toUpperCase() + "!");
        } else {
            System.out.println("   RESULTADO: EMPATE!");
        }
        System.out.println("==================================");
    }

    public void mensagens(String msg) {
        System.out.println(">>> " + msg);
    }
}