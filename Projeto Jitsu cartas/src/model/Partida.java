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
        System.out.println("\n🎮 Partida iniciada: " + jogador1.getNickname() + " vs " + jogador2.getNickname());
    }

    public void jogarRodada() {
        if (!emAndamento || deckJogador1.getTamanho() == 0 || deckJogador2.getTamanho() == 0) {
            System.out.println("A partida não pode continuar.");
            encerrarPartida();
            return;
        }

        System.out.println("\n--- RODADA " + rodadaAtual + " ---");
        
        Carta cartaJ1 = deckJogador1.obterCartaIndice(0);
        Carta cartaJ2 = deckJogador2.obterCartaIndice(0);

        deckJogador1.removerCarta(cartaJ1);
        deckJogador2.removerCarta(cartaJ2);
        
        cartasMesa.add(cartaJ1);
        cartasMesa.add(cartaJ2);

        System.out.println(jogador1.getNickname() + " jogou: " + cartaJ1);
        System.out.println(jogador2.getNickname() + " jogou: " + cartaJ2);

        cartaJ1.aplicarEfeito(this);
        cartaJ2.aplicarEfeito(this);

        Jogador vencedorRodada = determinarVencedorRodada(cartaJ1, cartaJ2);

        if (vencedorRodada == jogador1) {
            pontosJogador1++;
            System.out.println("✓ " + jogador1.getNickname() + " venceu a rodada!");
        } else if (vencedorRodada == jogador2) {
            pontosJogador2++;
            System.out.println("✓ " + jogador2.getNickname() + " venceu a rodada!");
        } else {
            System.out.println("- Rodada empatada!");
        }

        System.out.println("Placar: " + jogador1.getNickname() + " (" + pontosJogador1 + ") x " + jogador2.getNickname() + " (" + pontosJogador2 + ")");
        rodadaAtual++;

        if (verificarVitoria(jogador1) || verificarVitoria(jogador2)) {
            encerrarPartida();
        }
    }

    private Jogador determinarVencedorRodada(Carta cartaJ1, Carta cartaJ2) {
        gerais.enums.Elemento e1 = cartaJ1.getElemento();
        gerais.enums.Elemento e2 = cartaJ2.getElemento();
        int num1 = cartaJ1.getNumero();
        int num2 = cartaJ2.getNumero();

        if (e1 == e2) {
            return num1 > num2 ? jogador1 : (num2 > num1 ? jogador2 : null);
        }

        if ((e1 == gerais.enums.Elemento.FOGO && e2 == gerais.enums.Elemento.NEVE) ||
            (e1 == gerais.enums.Elemento.NEVE && e2 == gerais.enums.Elemento.AGUA) ||
            (e1 == gerais.enums.Elemento.AGUA && e2 == gerais.enums.Elemento.FOGO)) {
            return jogador1;
        }
        return jogador2;
    }

    private void encerrarPartida() {
        this.emAndamento = false;
        this.dataFim = LocalDateTime.now();

        System.out.println("\n🏁 PARTIDA FINALIZADA!");
        System.out.println("Placar Final: " + jogador1.getNickname() + " (" + pontosJogador1 + ") x " + jogador2.getNickname() + " (" + pontosJogador2 + ")");

        if (pontosJogador1 > pontosJogador2) {
            this.vencedor = jogador1;
            jogador1.incrementarVitorias();
            jogador2.incrementarDerrotas();
            System.out.println("🏆 VENCEDOR: " + jogador1.getNickname().toUpperCase());
        } else if (pontosJogador2 > pontosJogador1) {
            this.vencedor = jogador2;
            jogador2.incrementarVitorias();
            jogador1.incrementarDerrotas();
            System.out.println("🏆 VENCEDOR: " + jogador2.getNickname().toUpperCase());
        } else {
            System.out.println("🤝 RESULTADO: EMPATE!");
        }
    }

    public boolean verificarVitoria(Jogador p) {
        return !emAndamento || deckJogador1.getTamanho() == 0 || deckJogador2.getTamanho() == 0;
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
    public int getId() { return id; }
    public Jogador getJogador1() { return jogador1; }
    public Jogador getJogador2() { return jogador2; }
    public Deck getDeckJogador1() { return deckJogador1; }
    public Deck getDeckJogador2() { return deckJogador2; }
    public List<Carta> getCartasMesa() { return cartasMesa; }
    public Jogador getVencedor() { return vencedor; }
    public int getRodadaAtual() { return rodadaAtual; }
    public int getPontosJogador1() { return pontosJogador1; }
    public int getPontosJogador2() { return pontosJogador2; }
    public boolean isEmAndamento() { return emAndamento; }
    public LocalDateTime getDataInicio() { return dataInicio; }
    public LocalDateTime getDataFim() { return dataFim; }
}
