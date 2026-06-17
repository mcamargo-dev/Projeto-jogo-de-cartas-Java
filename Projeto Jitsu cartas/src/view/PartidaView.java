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

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Iniciar nova partida");
            System.out.println("2. Jogar rodada");
            System.out.println("3. Exibir estado da partida");
            System.out.println("4. Exibir cartas da mesa");
            System.out.println("5. Ver vencedor");
            System.out.println("0. Sair");
            System.out.println("===================================");
            
            opcao = InputHelper.lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    controller.criarPartida();
                    break;
                case 2:
                    controller.jogarRodada();
                    break;
                case 3:
                    exibirEstado();
                    break;
                case 4:
                    if (controller.getPartidaAtual() != null) {
                        exibirMesa(controller.getPartidaAtual().getCartasMesa());
                    } else {
                        System.out.println(">>> Nenhuma partida em andamento.");
                    }
                    break;
                case 5:
                    if (controller.getPartidaAtual() != null) {
                        exibirVencedor(controller.getPartidaAtual().getVencedor());
                    } else {
                        System.out.println(">>> Nenhuma partida em andamento.");
                    }
                    break;
                case 0:
                    System.out.println(">>> Até logo!");
                    break;
                default:
                    System.out.println(">>> Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void exibirEstado() {
        if (controller.getPartidaAtual() == null) {
            System.out.println(">>> Nenhuma partida em andamento.");
            return;
        }
        
        var partida = controller.getPartidaAtual();
        System.out.println("\n--- ESTADO DA PARTIDA ---");
        System.out.println("Partida: " + partida.getId());
        System.out.println("Jogador 1: " + partida.getJogador1().getNickname());
        System.out.println("Jogador 2: " + partida.getJogador2().getNickname());
        System.out.println("Rodada: " + partida.getRodadaAtual());
        System.out.println("Placar: " + partida.getPontosJogador1() + " x " + partida.getPontosJogador2());
        System.out.println("Cartas J1: " + partida.getDeckJogador1().getTamanho());
        System.out.println("Cartas J2: " + partida.getDeckJogador2().getTamanho());
        System.out.println("Status: " + (partida.isEmAndamento() ? "Em andamento" : "Finalizada"));
    }

    private void exibirMesa(List<Carta> cartas) {
        if (cartas == null || cartas.isEmpty()) {
            System.out.println(">>> A mesa está vazia.");
            return;
        }
        
        System.out.println("\n--- CARTAS NA MESA ---");
        for (Carta carta : cartas) {
            System.out.println("  " + carta.toString());
        }
    }

    private void exibirVencedor(Jogador vencedor) {
        System.out.println("\n=================================");
        if (vencedor != null) {
            System.out.println("  VENCEDOR: " + vencedor.getNickname().toUpperCase());
        } else {
            System.out.println("  RESULTADO: EMPATE");
        }
        System.out.println("=================================");
    }
}
