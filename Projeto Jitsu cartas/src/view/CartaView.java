package view;

import gerais.enums.Cor;
import gerais.enums.Elemento;
import gerais.enums.TipoEfeito;
import model.Carta;
import model.CartaEspecial;
import model.CartaNormal;
import util.InputHelper;

import java.util.List;

public class CartaView {

    public CartaView() {
    }

    public int menuCartas() {
        System.out.println("\n----- MENU CARTAS -----");
        System.out.println("1 - Cadastrar carta");
        System.out.println("2 - Editar carta");
        System.out.println("3 - Excluir carta");
        System.out.println("4 - Listar cartas");
        System.out.println("5 - Buscar carta por ID");
        System.out.println("0 - Voltar");

        return InputHelper.lerInt("Escolha uma opção: ");
    }

    public void exibirLista(List<Carta> cartas) {
        System.out.println("----- LISTA DE CARTAS -----");

        if (cartas.isEmpty()) {
            System.out.println("Nenhuma carta cadastrada.");
            return;
        }
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    public int escolherTipo() {
        System.out.println("----- TIPO DA CARTA -----");
        System.out.println("1 - Carta normal");
        System.out.println("2 - Carta especial");

        return InputHelper.lerInt("Escolha: ");
    }

    public void mensagens(String mensagem) {
        System.out.println(mensagem);
    }

    public Carta formCarta() {
        System.out.println("----- CADASTRO DE CARTA -----");

        int id = InputHelper.lerInt("ID: ");
        String nome = InputHelper.lerTexto("Nome: ");

        Elemento elemento = null;
        while (elemento == null) {
            System.out.println("Elemento disponível:");
            for (Elemento e : Elemento.values()) {
                System.out.println("- " + e);
            }
            String elementoStr = InputHelper.lerTexto("Elemento: ");
            try {
                elemento = Elemento.valueOf(elementoStr.toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println(">>> Elemento inválido. Tente novamente.");
            }
        }

        int numero = InputHelper.lerInt("Número: ");

        Cor cor = null;
        while (cor == null) {
            System.out.println("Cores disponíveis:");
            for (Cor c : Cor.values()) {
                System.out.println("- " + c);
            }
            String corStr = InputHelper.lerTexto("Cor: ");
            try {
                cor = Cor.valueOf(corStr.toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.println(">>> Cor inválida. Tente novamente.");
            }
        }

        int tipo = escolherTipo();

        if (tipo == 1) {
            return new CartaNormal(id, nome, elemento, numero, cor);
        } else {
            TipoEfeito efeito = null;
            while (efeito == null) {
                System.out.println("Efeitos disponíveis:");
                for (TipoEfeito e : TipoEfeito.values()) {
                    System.out.println("- " + e);
                }
                String efeitoStr = InputHelper.lerTexto("Efeito: ");
                try {
                    efeito = TipoEfeito.valueOf(efeitoStr.toUpperCase());
                } catch (IllegalArgumentException ex) {
                    System.out.println(">>> Efeito inválido. Tente novamente.");
                }
            }

            String descricao = InputHelper.lerTexto("Descrição do efeito: ");

            return new CartaEspecial(id, nome, elemento, numero, cor, efeito, descricao);
        }
    }
}