import java.time.LocalDateTime;

public class HistoricoPartida {

    private int id;
    private Partida partida;
    private Jogador jogadorVencedor;
    private String placarFinal;
    private LocalDateTime dataRegistro;

    public HistoricoPartida(int id, Partida partida, Jogador jogadorVencedor, String placarFinal) {
        this.id = id;
        this.partida = partida;
        this.jogadorVencedor = jogadorVencedor;
        this.placarFinal = placarFinal;
        this.dataRegistro = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Jogador getJogadorVencedor() {
        return jogadorVencedor;
    }

    public void setJogadorVencedor(Jogador jogadorVencedor) {
        this.jogadorVencedor = jogadorVencedor;
    }

    public String getPlacarFinal() {
        return placarFinal;
    }

    public void setPlacarFinal(String placarFinal) {
        this.placarFinal = placarFinal;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public String toString() {
        String nomeVencedor = (jogadorVencedor != null) ? jogadorVencedor.getNickname() : "Empate";
        int idPartida = (partida != null) ? partida.getId() : 0;

        return "Historico [ID: " + id +
                " | Partida: " + idPartida +
                " | Vencedor: " + nomeVencedor +
                " | Placar: " + placarFinal + "]";
    }
}