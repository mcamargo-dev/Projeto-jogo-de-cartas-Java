package controller;

import model.*;
import gerais.enums.Elemento;
import gerais.enums.Cor;
import util.InputHelper;

public class PartidaController {
    private Partida partidaAtual;
    private HistoricoPartida ultimoHistorico;

    public void criarPartida() {
        System.out.println("\n--- Nova Partida ---");
        
        String nick1 = InputHelper.lerTexto("Nome do Jogador 1: ");
        Jogador jogador1 = new Jogador(1, nick1);
        
        String nick2 = InputHelper.lerTexto("Nome do Jogador 2: ");
        Jogador jogador2 = new Jogador(2, nick2);

        Deck deck1 = criarDeckPadrao(1, jogador1, true);
        Deck deck2 = criarDeckPadrao(2, jogador2, false);

        int idPartida = (int) (System.currentTimeMillis() % 100000);
        this.partidaAtual = new Partida(idPartida, jogador1, jogador2, deck1, deck2);
        this.partidaAtual.iniciar();
        
        System.out.println("✓ Partida criada com sucesso!");
    }

    private Deck criarDeckPadrao(int idDeck, Jogador jogador, boolean jogador1) {
        Deck deck = new Deck(idDeck, "Deck " + jogador.getNickname(), jogador);
        
        if (jogador1) {
            // Deck especialista em FOGO
            deck.adicionarCarta(new CartaNormal(1, "Fogo Fraco", Elemento.FOGO, 2, Cor.VERMELHA));
            deck.adicionarCarta(new CartaNormal(2, "Fogo Médio", Elemento.FOGO, 4, Cor.VERMELHA));
            deck.adicionarCarta(new CartaNormal(3, "Fogo Forte", Elemento.FOGO, 7, Cor.VERMELHA));
            deck.adicionarCarta(new CartaEspecial(4, "Fogo Explosão", Elemento.FOGO, 5, Cor.VERMELHA, "Dobra o dano"));
            deck.adicionarCarta(new CartaNormal(5, "Agua Fraca", Elemento.AGUA, 3, Cor.AZUL));
            deck.adicionarCarta(new CartaNormal(6, "Agua Forte", Elemento.AGUA, 6, Cor.AZUL));
            deck.adicionarCarta(new CartaNormal(7, "Neve Fraca", Elemento.NEVE, 1, Cor.BRANCA));
            deck.adicionarCarta(new CartaNormal(8, "Neve Média", Elemento.NEVE, 3, Cor.BRANCA));
            deck.adicionarCarta(new CartaNormal(9, "Fogo Lava", Elemento.FOGO, 6, Cor.VERMELHA));
            deck.adicionarCarta(new CartaNormal(10, "Fogo Inferno", Elemento.FOGO, 8, Cor.VERMELHA));
        } else {
            // Deck especialista em NEVE
            deck.adicionarCarta(new CartaNormal(11, "Agua Leve", Elemento.AGUA, 2, Cor.AZUL));
            deck.adicionarCarta(new CartaNormal(12, "Agua Profunda", Elemento.AGUA, 5, Cor.AZUL));
            deck.adicionarCarta(new CartaNormal(13, "Neve Leve", Elemento.NEVE, 4, Cor.BRANCA));
            deck.adicionarCarta(new CartaNormal(14, "Neve Forte", Elemento.NEVE, 8, Cor.BRANCA));
            deck.adicionarCarta(new CartaEspecial(15, "Neve Blizzard", Elemento.NEVE, 6, Cor.BRANCA, "Congela o deck"));
            deck.adicionarCarta(new CartaNormal(16, "Neve Cristal", Elemento.NEVE, 5, Cor.BRANCA));
            deck.adicionarCarta(new CartaNormal(17, "Fogo Fraco", Elemento.FOGO, 1, Cor.VERMELHA));
            deck.adicionarCarta(new CartaNormal(18, "Agua Gelo", Elemento.AGUA, 9, Cor.AZUL));
            deck.adicionarCarta(new CartaNormal(19, "Neve Ártica", Elemento.NEVE, 7, Cor.BRANCA));
            deck.adicionarCarta(new CartaNormal(20, "Agua Tsunami", Elemento.AGUA, 8, Cor.AZUL));
        }
        
        return deck;
    }

    public void jogarRodada() {
        if (partidaAtual == null || !partidaAtual.isEmAndamento()) {
            System.out.println("Nenhuma partida em andamento.");
            return;
        }
        
        partidaAtual.jogarRodada();
    }

    public Partida getPartidaAtual() { return partidaAtual; }
    public HistoricoPartida getUltimoHistorico() { return ultimoHistorico; }
}
