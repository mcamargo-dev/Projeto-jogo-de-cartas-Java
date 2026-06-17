package model;

import gerais.interfaces.Jogavel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Jogavel {

    private int id;
    private Jogador jogador1;
    private Jogador jogador2;
    private Deck deckJogador1;
    private Deck deckJogador2;
    private List<Carta> cartasMesa;
    private Jogador vencedor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private int rodadaAtual;
    private int pontosJogador1;
    private int pontosJogador2;
    private boolean emAndamento;

    public Partida(int id, Jogador jogador1, Jogador jogador2, Deck deckJogador1, Deck deckJogador2) {
        this.id = id;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;
        this.cartasMesa = new ArrayList<>();
        this.dataInicio = LocalDateTime.now();
        this.rodadaAtual = 0;
        this.pontosJogador1 = 0;
        this.pontosJogador2 = 0;
        this.emAndamento = false;
    }

    public void iniciar() {
        this.emAndamento = true;
        this.rodadaAtual = 1;
        System.out.println("Partida " + id + " iniciada!");
        System.out.println("Jogador 1: " + jogador1.getNickname());
        System.out.println("Jogador 2: " + jogador2.getNickname());
    }

    public void jogarRodada() {
        if (!emAndamento) {
            System.out.println("A partida não está em andamento.");
            return;
        }

        if (deckJogador1.getTamanho() == 0 || deckJogador2.getTamanho() == 0) {
            System.out.println("Um ou ambos os decks estão vazios. Partida encerrada!");
            encerrarPartida();
            return;
        }

        System.out.println("\n--- RODADA " + rodadaAtual + " ---");

        // Pega a primeira carta de cada jogador
        Carta cartaJ1 = deckJogador1.obterCartaIndice(0);
        Carta cartaJ2 = deckJogador2.obterCartaIndice(0);

        // Remove as cartas dos decks
        deckJogador1.removerCarta(cartaJ1);
        deckJogador2.removerCarta(cartaJ2);

        // Adiciona à mesa
        cartasMesa.add(cartaJ1);
        cartasMesa.add(cartaJ2);

        System.out.println(jogador1.getNickname() + " jogou: " + cartaJ1.toString());
        System.out.println(jogador2.getNickname() + " jogou: " + cartaJ2.toString());

        // Aplicar efeitos especiais
        cartaJ1.aplicarEfeito(this);
        cartaJ2.aplicarEfeito(this);

        // Determinar vencedor da rodada
        Jogador vencedorRodada = determinarVencedorRodada(cartaJ1, cartaJ2);

        if (vencedorRodada == jogador1) {
            pontosJogador1++;
            System.out.println(">>> " + jogador1.getNickname() + " venceu a rodada!");
        } else if (vencedorRodada == jogador2) {
            pontosJogador2++;
            System.out.println(">>> " + jogador2.getNickname() + " venceu a rodada!");
        } else {
            System.out.println(">>> Rodada empatada!");
        }

        System.out.println("Pontos: " + jogador1.getNickname() + " (" + pontosJogador1 + ") x " + jogador2.getNickname() + " (" + pontosJogador2 + ")");

        rodadaAtual++;

        // Verificar se a partida acabou
        if (verificarVitoria(jogador1) || verificarVitoria(jogador2)) {
            encerrarPartida();
        }
    }

    private Jogador determinarVencedorRodada(Carta cartaJ1, Carta cartaJ2) {
        gerais.enums.Elemento e1 = cartaJ1.getElemento();
        gerais.enums.Elemento e2 = cartaJ2.getElemento();

        int num1 = cartaJ1.getNumero();
        int num2 = cartaJ2.getNumero();

        // Se são elementos iguais, compara números
        if (e1 == e2) {
            if (num1 > num2) {
                return jogador1;
            } else if (num2 > num1) {
                return jogador2;
            } else {
                return null; // Empate
            }
        }

        // Vantagens: FOGO > NEVE > AGUA > FOGO (ciclo)
        if ((e1 == gerais.enums.Elemento.FOGO && e2 == gerais.enums.Elemento.NEVE) ||
                (e1 == gerais.enums.Elemento.NEVE && e2 == gerais.enums.Elemento.AGUA) ||
                (e1 == gerais.enums.Elemento.AGUA && e2 == gerais.enums.Elemento.FOGO)) {
            return jogador1;
        } else {
            return jogador2;
        }
    }

    private void encerrarPartida() {
        this.emAndamento = false;
        this.dataFim = LocalDateTime.now();

        System.out.println("\n========================================");
        System.out.println("           PARTIDA FINALIZADA!");
        System.out.println("========================================");
        System.out.println("Placar Final: " + jogador1.getNickname() + " (" + pontosJogador1 + ") x " + jogador2.getNickname() + " (" + pontosJogador2 + ")");

        if (pontosJogador1 > pontosJogador2) {
            this.vencedor = jogador1;
            jogador1.incrementarVitorias();
            jogador2.incrementarDerrotas();
            System.out.println("🏆 VENCEDOR: " + jogador1.getNickname().toUpperCase() + "!");
        } else if (pontosJogador2 > pontosJogador1) {
            this.vencedor = jogador2;
            jogador2.incrementarVitorias();
            jogador1.incrementarDerrotas();
            System.out.println("🏆 VENCEDOR: " + jogador2.getNickname().toUpperCase() + "!");
        } else {
            this.vencedor = null; // Empate
            System.out.println("🤝 RESULTADO: EMPATE!");
        }
        System.out.println("========================================\n");
    }

    public void definirVencedor(Jogador jogador) {
        this.vencedor = jogador;
        this.dataFim = LocalDateTime.now();
    }

    public boolean verificarVitoria(Jogador p) {
        if (!emAndamento) {
            return true;
        }
        if (deckJogador1.getTamanho() == 0 || deckJogador2.getTamanho() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void resetarEstado() {
        this.cartasMesa.clear();
        this.vencedor = null;
        this.dataFim = null;
        this.rodadaAtual = 0;
        this.pontosJogador1 = 0;
        this.pontosJogador2 = 0;
        this.emAndamento = false;
    }

    @Override
    public int getId() {
        return id;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Deck getDeckJogador1() {
        return deckJogador1;
    }

    public void setDeckJogador1(Deck deckJogador1) {
        this.deckJogador1 = deckJogador1;
    }

    public Deck getDeckJogador2() {
        return deckJogador2;
    }

    public void setDeckJogador2(Deck deckJogador2) {
        this.deckJogador2 = deckJogador2;
    }

    public List<Carta> getCartasMesa() {
        return cartasMesa;
    }

    public void setCartasMesa(List<Carta> cartasMesa) {
        this.cartasMesa = cartasMesa;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public int getRodadaAtual() {
        return rodadaAtual;
    }

    public void setRodadaAtual(int rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }

    public int getPontosJogador1() {
        return pontosJogador1;
    }

    public void setPontosJogador1(int pontosJogador1) {
        this.pontosJogador1 = pontosJogador1;
    }

    public int getPontosJogador2() {
        return pontosJogador2;
    }

    public void setPontosJogador2(int pontosJogador2) {
        this.pontosJogador2 = pontosJogador2;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public void setEmAndamento(boolean emAndamento) {
        this.emAndamento = emAndamento;
    }

    public String getPlacarFinal() {
        return pontosJogador1 + " x " + pontosJogador2;
    }
}
