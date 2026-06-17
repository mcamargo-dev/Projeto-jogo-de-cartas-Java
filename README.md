🃏 Projeto-jogo-de-cartas-Java
Jogo de cartas com mecânicas de elementos (Fogo, Água, Neve) desenvolvido em Java como projeto acadêmico. O sistema contempla desde o cadastro de cartas e jogadores até partidas completas com efeitos especiais, sistema de faixas de progressão e histórico de confrontos.

✨ Funcionalidades
Gerenciamento completo de Cartas

Cadastro, edição, exclusão e listagem de cartas normais e especiais.

Cartas especiais com efeitos como DOBRO_FORCA e MEIA_FORCA.

Catálogos de Cartas

Agrupamento de cartas em catálogos para organização.

Sistema de Jogadores

Cadastro, edição de nickname, atualização de faixa (progressão).

Registro de vitórias/derrotas.

Decks

Criação e gerenciamento de decks associados a jogadores.

Decks padrão para testes rápidos.

Partidas

Confronto entre dois jogadores, cada um com seu deck.

Lógica de turnos com comparação de elementos (Fogo > Neve > Água > Fogo).

Aplicação de efeitos especiais durante a rodada.

Placar dinâmico e finalização automática ao término dos decks.

Sistema de Faixas (Ranking)

Progressão de faixas (Branca → Amarela → ... → Preta).

Ganho de pontos e promoção automática.

Histórico de Partidas

Registro em arquivo .txt com vencedor, placar e data.

Filtro por jogador e exclusão de registros.

Logs do Sistema

Gravação de eventos e erros em arquivo de log.

🧱 Tecnologias e Conceitos
Java 17 (ou superior)

Programação Orientada a Objetos – herança, polimorfismo, encapsulamento, abstração.

Padrão MVC – separação clara entre Model, View e Controller.

Repositórios em memória – simulação de banco de dados para entidades.

Arquivos – persistência de histórico e logs via FileUtil.

Enums – para elementos, cores, tipos de efeito e faixas.

Interfaces – Jogavel para padronizar reset de estado.

Tratamento de exceções – exceções personalizadas para validações.

📁 Estrutura do Projeto
text
├── model/               # Entidades do domínio
│   ├── Carta.java
│   ├── CartaEspecial.java
│   ├── CartaNormal.java
│   ├── CatalogoCartas.java
│   ├── Deck.java
│   ├── EfeitoEspecial.java
│   ├── FaixaProgressao.java
│   ├── HistoricoPartida.java
│   ├── Jogador.java
│   └── Partida.java
│
├── controller/          # Lógica de negócio e orquestração
│   ├── CartaController.java
│   ├── CatalogoController.java
│   ├── DeckController.java
│   ├── EfeitoEspecialController.java
│   ├── FaixaController.java
│   ├── HistoricoController.java
│   ├── JogadorController.java
│   └── PartidaController.java
│
├── view/                # Interfaces com o usuário (console)
│   ├── CartaView.java
│   ├── CatalogoView.java
│   ├── DeckView.java
│   ├── EfeitoEspecialView.java
│   ├── FaixaView.java
│   ├── HistoricoView.java
│   ├── JogadorView.java
│   └── PartidaView.java
│
├── repository/          # Repositórios (simulação de BD)
│   ├── CartaRepository.java
│   ├── CatalogoRepository.java
│   ├── DeckRepository.java
│   ├── HistoricoRepository.java
│   └── JogadorRepository.java
│
├── enums/               # Enumeradores
│   ├── Cor.java
│   ├── Elemento.java
│   ├── Faixa.java
│   └── TipoEfeito.java
│
├── exceptions/          # Exceções personalizadas
│   ├── CartaInvalidaException.java
│   ├── DeckInvalidoException.java
│   ├── JogadorNaoEncontradoException.java
│   ├── PartidaException.java
│   └── RegraNegocioException.java
│
├── interfaces/          # Interfaces
│   └── Jogavel.java
│
├── util/                # Classes utilitárias
│   ├── Constantes.java
│   ├── DateUtil.java
│   ├── FileUtil.java
│   ├── InputHelper.java
│   └── LogService.java
│
└── Main.java            # Ponto de entrada do sistema
▶️ Como Executar
Clone o repositório (ou baixe os arquivos).

Abra o projeto no IntelliJ IDEA (ou qualquer IDE Java compatível).

Compile e execute a classe Main.java.

Siga as instruções do menu interativo no console.

⚠️ Observação: Os dados são armazenados em memória e em arquivos .txt (histórico e logs). Os arquivos são criados automaticamente na raiz do projeto.

👥 Contribuidores
Projeto desenvolvido por 4 integrantes como trabalho acadêmico para a disciplina de Programação Orientada a Objetos.

Marcelo Camargo

Daniel Felipe

Leonardo Macena

Gabriel Levandowski

📌 Melhorias Futuras
Persistência em banco de dados (JDBC/JPA).

Interface gráfica (JavaFX ou Swing).

Modo multiplayer online.

Mais efeitos especiais e elementos.

Sistema de recompensas e conquistas.

📄 Licença
Este projeto é de uso acadêmico e não possui licença definida.

Divirta-se jogando! 🎮
