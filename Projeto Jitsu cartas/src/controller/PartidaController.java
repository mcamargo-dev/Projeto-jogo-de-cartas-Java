package Controller;

import Model.Partida;
import Model.Jogador;
import Model.Carta;
import Model.HistoricoPartida;
import enums.Elemento;

public class PartidaController {

    private Partida partidaAtual;

    public void iniciarPartida(Partida partida) {
        this.partidaAtual = partida;
        this.partidaAtual.iniciar();
    }

    public void jogarRodada() {
        if (partidaAtual != null) {
            partidaAtual.jogarRodada();
        }
    }

    public Jogador processarJogada(Carta cartaJ1, Carta cartaJ2) {
        Elemento e1 = cartaJ1.getElemento();
        Elemento e2 = cartaJ2.getElemento();

        if (e1 == e2) {
            if (cartaJ1.getNumero() > cartaJ2.getNumero()) {
                return partidaAtual.getJogador1();
            }
            if (cartaJ2.getNumero() > cartaJ1.getNumero()) {
                return partidaAtual.getJogador2();
            }
            return null;
        }

        if ((e1 == Elemento.FOGO && e2 == Elemento.NEVE) ||
                (e1 == Elemento.NEVE && e2 == Elemento.AGUA) ||
                (e1 == Elemento.AGUA && e2 == Elemento.FOGO)) {
            return partidaAtual.getJogador1();
        } else {
            return partidaAtual.getJogador2();
        }
    }

    public boolean verificarVencedor(Jogador jogador) {
        if (partidaAtual != null) {
            return partidaAtual.verificarVitoria(jogador);
        }
        return false;
    }

    public void encerrarPartida(Jogador vencedor, String placarFinal) {
        if (partidaAtual != null) {
            partidaAtual.definirVencedor(vencedor);

            int idHistorico = (int) (System.currentTimeMillis() % 100000);
            HistoricoPartida historico = new HistoricoPartida(idHistorico, partidaAtual, vencedor, placarFinal);

            HistoricoController historicoController = new HistoricoController();
            historicoController.salvarHistorico(historico);
        }
    }

    public Partida getPartidaAtual() {
        return partidaAtual;
    }
}