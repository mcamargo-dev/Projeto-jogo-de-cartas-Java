package model;

import gerais.enums.TipoEfeito;

public class EfeitoEspecial {
    private int id;
    private String nome;
    private String descricao;
    private TipoEfeito tipoEfeito;

    public EfeitoEspecial(int id, String nome, String descricao, TipoEfeito tipoEfeito) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoEfeito = tipoEfeito;
    }

    public void aplicar(Partida partida) {
        System.out.println("Aplicando efeito: " + nome);
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public TipoEfeito getTipoEfeito() { return tipoEfeito; }
    public void setTipoEfeito(TipoEfeito tipoEfeito) { this.tipoEfeito = tipoEfeito; }

    @Override
    public String toString() {
        return nome + " (" + tipoEfeito + ")";
    }
}
