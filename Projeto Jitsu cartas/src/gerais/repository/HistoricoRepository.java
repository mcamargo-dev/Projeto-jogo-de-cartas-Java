package Repository;

import Model.HistoricoPartida;
import Model.Partida;
import Model.Jogador;
import Util.FileUtil;
import Util.Constantes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HistoricoRepository {

    public void salvar(HistoricoPartida historico) {
        List<String> linhas = new ArrayList<>();

        int partidaId = (historico.getPartida() != null) ? historico.getPartida().getId() : 0;
        int vencedorId = (historico.getJogadorVencedor() != null) ? historico.getJogadorVencedor().getId() : 0;

        String linha = historico.getId() + ";" +
                partidaId + ";" +
                vencedorId + ";" +
                historico.getPlacarFinal() + ";" +
                historico.getDataRegistro().toString();

        linhas.add(linha);
        FileUtil.escreverArquivo(Constantes.ARQUIVO_HISTORICO, linhas);
    }

    public List<HistoricoPartida> listarTodos() {
        List<HistoricoPartida> historicos = new ArrayList<>();
        List<String> linhas = FileUtil.lerArquivo(Constantes.ARQUIVO_HISTORICO);

        for (String linha : linhas) {
            String[] dados = linha.split(";");
            if (dados.length >= 5) {
                int id = Integer.parseInt(dados[0]);
                int partidaId = Integer.parseInt(dados[1]);
                int vencedorId = Integer.parseInt(dados[2]);
                String placar = dados[3];
                LocalDateTime dataRegistro = LocalDateTime.parse(dados[4]);

                Partida partidaMock = new Partida(partidaId, null, null, null, null);
                Jogador vencedorMock = new Jogador(vencedorId, "Jogador " + vencedorId);

                HistoricoPartida hp = new HistoricoPartida(id, partidaMock, vencedorMock, placar);
                hp.setDataRegistro(dataRegistro);

                historicos.add(hp);
            }
        }
        return historicos;
    }

    public HistoricoPartida buscarPorId(int id) {
        for (HistoricoPartida hp : listarTodos()) {
            if (hp.getId() == id) {
                return hp;
            }
        }
        return null;
    }

    public void excluir(int id) {
        List<HistoricoPartida> todos = listarTodos();
        List<String> novasLinhas = new ArrayList<>();
        boolean encontrou = false;

        for (HistoricoPartida hp : todos) {
            if (hp.getId() != id) {
                int partidaId = (hp.getPartida() != null) ? hp.getPartida().getId() : 0;
                int vencedorId = (hp.getJogadorVencedor() != null) ? hp.getJogadorVencedor().getId() : 0;

                String linha = hp.getId() + ";" + partidaId + ";" + vencedorId + ";" + hp.getPlacarFinal() + ";" + hp.getDataRegistro().toString();
                novasLinhas.add(linha);
            } else {
                encontrou = true;
            }
        }

        if (encontrou) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.ARQUIVO_HISTORICO, false))) {
                for (String linha : novasLinhas) {
                    bw.write(linha);
                    bw.newLine();
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    public void atualizar(HistoricoPartida historicoAtualizado) {
        excluir(historicoAtualizado.getId());
        salvar(historicoAtualizado);
    }
}