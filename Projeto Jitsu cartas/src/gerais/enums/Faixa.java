package gerais.enums;

public enum Faixa {
    BRANCA, AMARELA, LARANJA, VERDE, AZUL, VERMELHA, ROXA, MARROM, PRETA;

    public Faixa proxima() {
        int proximoOrdinal = this.ordinal() + 1;
        if (proximoOrdinal < Faixa.values().length) {
            return Faixa.values()[proximoOrdinal];
        }
        return this; // Já está na faixa preta (máxima)
    }
}
