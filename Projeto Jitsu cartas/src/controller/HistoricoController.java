package controller;

import model.HistoricoPartida;
import gerais.repository.HistoricoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoController {

    private HistoricoRepository repository;

    public HistoricoController() {
        this.repository = new HistoricoRepository();
    }

    public void salvarHistorico(HistoricoPartida historico) {
        repository.salvar(historico);
    }

    public List<HistoricoPartida> listarHistorico() {
        return repository.listarTodos();
    }

    public List<HistoricoPartida> buscarPorJogador(int jogadorId) {
        List<HistoricoPartida> todos = repository.listarTodos();
        List<HistoricoPartida> filtrados = new ArrayList<>();

        for (HistoricoPartida hp : todos) {
            if (hp.getJogadorVencedor() != null && hp.getJogadorVencedor().getId() == jogadorId) {
                filtrados.add(hp);
            }
        }
        return filtrados;
    }

    public void excluirRegistro(int id) {
        repository.excluir(id);
    }

    public List<HistoricoPartida> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<HistoricoPartida> todos = repository.listarTodos();
        List<HistoricoPartida> filtrados = new ArrayList<>();

        for (HistoricoPartida hp : todos) {
            LocalDateTime data = hp.getDataRegistro();
            if (data != null && !data.isBefore(inicio) && !data.isAfter(fim)) {
                filtrados.add(hp);
            }
        }
        return filtrados;
    }
}   