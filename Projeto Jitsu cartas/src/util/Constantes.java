package Util;

public class Constantes {

    // Arquivos de persistência
    public static String ARQUIVO_JOGADORES = "dados/jogadores.txt";
    public static String ARQUIVO_DECKS = "dados/decks.txt";
    public static String ARQUIVO_CARTAS = "dados/cartas.txt";
    public static String ARQUIVO_PARTIDAS = "dados/partidas.txt";
    public static String ARQUIVO_HISTORICO = "dados/historico.txt";
    public static String ARQUIVO_LOG = "dados/log.txt";

    // Impede instanciação
    private Constantes() {
        throw new UnsupportedOperationException(
                "Classe utilitária não pode ser instanciada.");
    }

}