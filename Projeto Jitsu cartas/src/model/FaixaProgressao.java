package model;

import gerais.enums.Faixa;

public class FaixaProgressao {

    private Jogador jogador;
    private Faixa faixaAtual;
    private int pontosAtuais;
    private int pontosProximoNivel;

    public FaixaProgressao(Jogador jogador) {
        this.jogador = jogador;
        this.faixaAtual = Faixa.BRANCA;
        this.pontosAtuais = 0;
        this.pontosProximoNivel = 100; // Meta padrão inicial
    }

    public double calcularProgresso() {
        if (pontosProximoNivel == 0) return 100.0;
        return ((double) pontosAtuais / pontosProximoNivel) * 100.0;
    }

    public boolean verificarPromocao() {
        return this.pontosAtuais >= this.pontosProximoNivel;
    }

    public void promover() {
        if (verificarPromocao()) {
            Faixa proxima = faixaAtual.proxima();
            if (proxima != faixaAtual) {
                this.pontosAtuais -= this.pontosProximoNivel;
                this.faixaAtual = proxima;
                this.pontosProximoNivel = (this.faixaAtual.ordinal() + 1) * 100; // Escalonamento de XP
            }
        }
    }

    // Getters e Setters
    public Jogador getJogador() { return jogador; }
    public void setJogador(Jogador jogador) { this.jogador = jogador; }
    public Faixa getFaixaAtual() { return faixaAtual; }
    public void setFaixaAtual(Faixa faixaAtual) { this.faixaAtual = faixaAtual; }
    public int getPontosAtuais() { return pontosAtuais; }
    public void setPontosAtuais(int pontosAtuais) { this.pontosAtuais = pontosAtuais; }
    public int getPontosProximoNivel() { return pontosProximoNivel; }
    public void setPontosProximoNivel(int pontosProximoNivel) { this.pontosProximoNivel = pontosProximoNivel; }

}
