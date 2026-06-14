package View;

import Controller.HistoricoController;
import Model.HistoricoPartida;
import Util.InputHelper;

import java.util.List;

public class HistoricoView {

    private HistoricoController controller;

    public HistoricoView() {
        this.controller = new HistoricoController();
    }

    public void menuHistorico() {
        int opcao;
        do {
            System.out.println("\n--- MENU HISTORICO ---");
            System.out.println("1. Listar todo o historico");
            System.out.println("2. Filtrar por jogador");
            System.out.println("3. Excluir registro");
            System.out.println("0. Voltar");
            opcao = InputHelper.lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    exibirLista(controller.listarHistorico());
                    break;
                case 2:
                    filtrarPorJogador();
                    break;
                case 3:
                    int id = InputHelper.lerInt("Digite o ID do historico para excluir: ");
                    controller.excluirRegistro(id);
                    mensagens("Registro excluido com sucesso.");
                    break;
                case 0:
                    break;
                default:
                    mensagens("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    public void exibirLista(List<HistoricoPartida> lista) {
        if (lista.isEmpty()) {
            mensagens("Nenhum historico encontrado.");
            return;
        }
        for (HistoricoPartida hp : lista) {
            System.out.println(hp.toString());
        }
    }

    public void exibirDetalhes(HistoricoPartida hp) {
        if (hp != null) {
            System.out.println("\n--- DETALHES DA PARTIDA ---");
            System.out.println("ID Historico: " + hp.getId());
            System.out.println("ID Partida: " + (hp.getPartida() != null ? hp.getPartida().getId() : "N/A"));
            System.out.println("Vencedor: " + (hp.getJogadorVencedor() != null ? hp.getJogadorVencedor().getNickname() : "Empate"));
            System.out.println("Placar Final: " + hp.getPlacarFinal());
            System.out.println("Data: " + hp.getDataRegistro());
        } else {
            mensagens("Historico nao encontrado.");
        }
    }

    public void filtrarPorJogador() {
        int idJogador = InputHelper.lerInt("Digite o ID do jogador para filtrar: ");
        List<HistoricoPartida> filtrados = controller.buscarPorJogador(idJogador);
        exibirLista(filtrados);
    }

    public void mensagens(String msg) {
        System.out.println(">>> " + msg);
    }
}