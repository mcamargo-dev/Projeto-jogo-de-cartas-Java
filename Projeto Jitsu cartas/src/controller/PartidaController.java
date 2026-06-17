package controller;

import model.Partida;
import model.Jogador;
import model.Deck;
import model.Carta;
import model.CartaNormal;
import model.CartaEspecial;
import model.HistoricoPartida;
import gerais.enums.Elemento;
import gerais.enums.Cor;
import util.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class PartidaController {

    private Partida partidaAtual;

    public void criarPartida() {
        System.out.println("\n--- CRIAR NOVA PARTIDA ---");

        // Criar jogadores
        String nick1 = InputHelper.lerTexto("Nome do Jogador 1: ");
        Jogador jogador1 = new Jogador(1, nick1);

        String nick2 = InputHelper.lerTexto("Nome do Jogador 2: ");
        Jogador jogador2 = new Jogador(2, nick2);

        // Criar decks DIFERENTES para cada jogador
        Deck deck1 = criarDeckJogador1(1, jogador1);
        Deck deck2 = criarDeckJogador2(2, jogador2);

        // Criar partida
        int idPartida = (int) (System.currentTimeMillis() % 100000);
        this.partidaAtual = new Partida(idPartida, jogador1, jogador2, deck1, deck2);
        this.partidaAtual.iniciar();

        System.out.println(">>> Partida criada com sucesso!");
    }

    private Deck criarDeckJogador1(int idDeck, Jogador jogador) {
        Deck deck = new Deck(idDeck, "Deck " + jogador.getNickname(), jogador);

        // DECK DO JOGADOR 1 - Especialista em FOGO e AGUA
        deck.adicionarCarta(new CartaNormal(101, "Fogo Fraco", Elemento.FOGO, 2, Cor.VERMELHA));
        deck.adicionarCarta(new CartaNormal(102, "Fogo Forte", Elemento.FOGO, 7, Cor.VERMELHA));
        deck.adicionarCarta(new CartaEspecial(103, "Fogo Explosão", Elemento.FOGO, 5, Cor.VERMELHA, "Dobra o dano"));
        deck.adicionarCarta(new CartaNormal(104, "Fogo Médio", Elemento.FOGO, 4, Cor.VERMELHA));

        deck.adicionarCarta(new CartaNormal(105, "Agua Fraca", Elemento.AGUA, 3, Cor.AZUL));
        deck.adicionarCarta(new CartaNormal(106, "Agua Forte", Elemento.AGUA, 6, Cor.AZUL));
        deck.adicionarCarta(new CartaEspecial(107, "Agua Tsunami", Elemento.AGUA, 8, Cor.AZUL, "Anula a próxima carta"));

        // Uma carta de NEVE (desvantagem)
        deck.adicionarCarta(new CartaNormal(108, "Neve Fraca", Elemento.NEVE, 1, Cor.BRANCA));
        deck.adicionarCarta(new CartaNormal(109, "Neve Média", Elemento.NEVE, 3, Cor.BRANCA));
        deck.adicionarCarta(new CartaNormal(110, "Fogo Lava", Elemento.FOGO, 6, Cor.VERMELHA));

        return deck;
    }

    private Deck criarDeckJogador2(int idDeck, Jogador jogador) {
        Deck deck = new Deck(idDeck, "Deck " + jogador.getNickname(), jogador);

        // DECK DO JOGADOR 2 - Especialista em AGUA e NEVE
        deck.adicionarCarta(new CartaNormal(201, "Agua Leve", Elemento.AGUA, 2, Cor.AZUL));
        deck.adicionarCarta(new CartaNormal(202, "Agua Profunda", Elemento.AGUA, 5, Cor.AZUL));
        deck.adicionarCarta(new CartaEspecial(203, "Agua Correnteza", Elemento.AGUA, 7, Cor.AZUL, "Inverte o placar"));

        deck.adicionarCarta(new CartaNormal(204, "Neve Leve", Elemento.NEVE, 4, Cor.BRANCA));
        deck.adicionarCarta(new CartaNormal(205, "Neve Forte", Elemento.NEVE, 8, Cor.BRANCA));
        deck.adicionarCarta(new CartaEspecial(206, "Neve Blizzard", Elemento.NEVE, 6, Cor.BRANCA, "Congela o deck"));
        deck.adicionarCarta(new CartaNormal(207, "Neve Cristal", Elemento.NEVE, 5, Cor.BRANCA));

        // Uma carta de FOGO (desvantagem)
        deck.adicionarCarta(new CartaNormal(208, "Fogo Fraco", Elemento.FOGO, 1, Cor.VERMELHA));
        deck.adicionarCarta(new CartaNormal(209, "Agua Gelo", Elemento.AGUA, 9, Cor.AZUL));
        deck.adicionarCarta(new CartaNormal(210, "Neve Ártica", Elemento.NEVE, 7, Cor.BRANCA));

        return deck;
    }

    public void iniciarPartida(Partida partida) {
        this.partidaAtual = partida;
        this.partidaAtual.iniciar();
    }

    public void jogarRodada() {
        if (partidaAtual == null) {
            System.out.println(">>> Nenhuma partida em andamento!");
            return;
        }

        if (!partidaAtual.isEmAndamento()) {
            System.out.println(">>> A partida não está em andamento!");
            return;
        }

        partidaAtual.jogarRodada();
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
