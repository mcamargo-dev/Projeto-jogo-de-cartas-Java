package view;

import gerais.enums.TipoEfeito;
import model.EfeitoEspecial;
import util.InputHelper;

import java.util.List;

public class EfeitoEspecialView {

    public int menuEfeitos() {
        System.out.println("\n=== GERENCIAMENTO DE EFEITOS ESPECIAIS ===");
        System.out.println("1. Criar Novo Efeito");
        System.out.println("2. Editar Efeito Existente");
        System.out.println("3. Excluir Efeito");
        System.out.println("4. Listar Todos os Efeitos");
        System.out.println("0. Voltar");
        return InputHelper.lerInt("Escolha uma opção: ");
    }

    public void exibirLista(List<EfeitoEspecial> efeitos) {
        System.out.println("\n--- LISTA DE EFEITOS ESPECIAIS CADASTRADOS ---");
        if (efeitos.isEmpty()) {
            System.out.println("Nenhum efeito registrado.");
        } else {
            for (EfeitoEspecial e : efeitos) {
                System.out.println(e);
            }
        }
    }

    public EfeitoEspecial formEfeito(int proximoId) {
        InputHelper.lerTexto(""); // Limpar buffer
        System.out.println("\n--- FORMULÁRIO DE NOVO EFEITO ---");
        System.out.print("Nome do Efeito: ");
        String nome = InputHelper.lerTexto("");
        System.out.print("Descrição do Efeito: ");
        String descricao = InputHelper.lerTexto("");

        System.out.println("Escolha o Tipo de Efeito:");
        TipoEfeito[] tipos = TipoEfeito.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        int opTipo = InputHelper.lerInt("Opção");
        TipoEfeito tipoEscolhido = tipos[Math.max(0, Math.min(opTipo - 1, tipos.length - 1))];

        return new EfeitoEspecial(proximoId, nome, descricao, tipoEscolhido);
    }

    public int pedirId(String acao) {
        return InputHelper.lerInt("Digite o ID do efeito que deseja " + acao + ": ");
    }

    public void mensagens(String mensagem) {
        System.out.println("[Efeito System] " + mensagem);
    }

}
