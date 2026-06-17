package gerais.enums;

public enum Faixa {
    BRANCA,
    AMARELA,
    LARANJA,
    VERDE,
    AZUL,
    ROXA,
    MARROM,
    PRETA;

    public Faixa proxima() {
        if (this.ordinal() < PRETA.ordinal()) {
            return Faixa.values()[this.ordinal() + 1];
        }
        return this;
    }
}
