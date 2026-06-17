package view;

import gerais.enums.Faixa;
import model.Jogador;
import util.InputHelper;
import java.util.List;

public class JogadorView {

    public int menuJogadores() {
        System.out.println("\n----- MENU JOGADORES -----");
        System.out.println("1 - Cadastrar jogador");
        System.out.println("2 - Editar nickname");
        System.out.println("3 - Excluir jogador");
        System.out.println("4 - Listar jogadores");
        System.out.println("5 - Buscar jogador por ID");
        System.out.println("6 - Atualizar faixa");
        System.out.println("0 - Voltar");
        return InputHelper.lerInt("Escolha uma opção: ");
    }

    public void exibirLista(List<Jogador> l) {
        System.out.println("\n----- LISTA DE JOGADORES -----");
        if (l.isEmpty()) {
            System.out.println("Nenhum jogador cadastrado.");
            return;
        }
        for (Jogador j : l) {
            System.out.println(j);
        }
    }

    public Jogador lerDados() {
        System.out.println("\n----- NOVO JOGADOR -----");
        int id = InputHelper.lerInt("ID: ");
        String nome = InputHelper.lerTexto("Nickname: ");
        return new Jogador(id, nome);
    }

    public void exibirDetalhes(Jogador j) {
        System.out.println("\n----- DETALHES DO JOGADOR -----");
        System.out.println("ID: " + j.getId());
        System.out.println("Nickname: " + j.getNickname());
        System.out.println("Vitórias: " + j.getVitorias());
        System.out.println("Derrotas: " + j.getDerrotas());
        System.out.println("Faixa: " + j.getFaixa());
    }

    public Faixa lerFaixa() {
        Faixa faixa = null;
        while (faixa == null) {
            System.out.println("Faixas disponíveis:");
            for (Faixa f : Faixa.values()) {
                System.out.println("- " + f);
            }
            String faixaStr = InputHelper.lerTexto("Nova Faixa: ");
            try {
                faixa = Faixa.valueOf(faixaStr.toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println(">>> Faixa inválida. Tente novamente.");
            }
        }
        return faixa;
    }

    public void mensagens(String m) {
        System.out.println(m);
    }
}