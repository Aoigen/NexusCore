package com.aoigen.nexuscore.dao; // Define o pacote onde a classe será localizada

// Importando as classes necessárias para trabalhar com conexões JDBC e exceções
import java.sql.Connection; // Classe para criar e gerenciar uma conexão com o banco de dados
import java.sql.DriverManager; // Classe usada para obter a conexão com o banco de dados
import java.sql.PreparedStatement; // Classe usada para executar uma consulta SQL de forma segura
import java.sql.SQLException; // Classe que representa as exceções relacionadas a erros de SQL

// Definindo a classe 'UserDAO', responsável por interagir com o banco de dados
// Outras classes (servlets) como por exemplo UserRegisterServlet, vão instanciar o UserDAO, que fornecerá métodos como:
// - Registro de novos usuários
// - Autenticação de usuários existentes
// - Manipulação e gerenciamento de dados de usuários
// Cada servlet vai agir como um ponto de entrada para o programa, semelhante ao método "main" em Java
// O UserDAO em si apenas fornecerá métodos, não sendo ele um servlet ou método "main"
public class UserDAO {

    // Definindo constantes para armanezar as credencias de conexão com o banco de dados
    // Em ambientes corporativos, para mais segurança, podemos armazenar esses dados em arquivos .properties ou usar bibliotecas para criptografar esses dados
    // Este é um projeto acadêmico e não possui essa necessidade
    // Portanto, sempre remova as credênciais antes de empurrar isso em repositórios ou outros lugares na web
    private static final String DB_URL = "jdbc:mysql://localhost:3306/NexusCore"; // URL do banco de dados MySQL
    private static final String DB_USER = "root"; // Usuário do banco de dados
    private static final String DB_PASSWORD = ""; // Senha do banco de dados (vazia neste caso)

    // Método para registrar um usuário no banco de dados
    // Este método receberá os dados do usuário e irá inserí-los na tabela 'users' do banco de dados
    public boolean registerUser(String complete_name, String email, String telephone, String username, String password) {

        // Exibindo uma mensagem no console informando que o processo de registro está começando
        System.out.println("Tentando registrar usuário...");

        // Essa String armazena a consulta SQL que será executada no banco de dados para registrar o novo usuário
        // Ela utiliza placeholders ('?') para evitar SQL Injection, onde os valores serão substituídos mais tarde
        // Ela também otimiza consultas que são executadas várias vezes, já que elas são pré-compiladas pelo banco de dados
        String query = "INSERT INTO users (complete_name, email, telephone, username, password) VALUES (?, ?, ?, ?, ?)";

        try {
            // Tentando (try) carregar a classe do driver JDBC do MySQL
            // Essa classe é necessária para que o Java saiba como se comunicar com o banco de dados MySQL
            // É nessa parte que escolhemos qual será o banco de dados utilizado. O Nexus Core utilizará MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carrega o driver do MySQL para se comunicar com o JDBC

        } catch (ClassNotFoundException e) {
            // Se o driver não for encontrado, armazena o motivo em "e", exibindo uma mensagem de erro e
            // imprimindo a stack trace (pilha de chamadas) para diagnosticar o erro
            System.out.println("Driver MySQL não encontrado: " + e.getMessage()); // Exibe o motivo do erro.
            e.printStackTrace(); // Imprime a pilha de chamadas (stack trace) no console, ajudando no diagnóstico do erro.
        }
        
        // Até aqui, o Driver SQL deve estar carregado e a String (query) preparada para ter seus dados substituídos...
        // A parte a seguir faz a conexão com o banco e executa a query de inserção
        try (
            // A 'Connection' representa a conexão com o banco de dados, onde vamos enviar e receber dados
            // O 'DriverManager' é responsável por estabelecer a conexão com o banco
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // Conecta ao banco de dados
            // 'PreparedStatement' é usado para preparar a consulta SQL de forma segura e eficiente
            // Essa classe prepara a consulta SQL usando a String "query" criada no começo, que armazena a estrutura com os placeholders
            PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            // Agora que temos o 'PreparedStatement', substituímos os placeholders (?) pelos valores fornecidos no método
            // O número 1 refere-se ao primeiro '?' na consulta SQL. O primeiro valor que será substituído é o complete_name
            // No JDBC, a indexação dos parâmetros de uma consulta SQL preparada começa em 1, ao invés de 0,
            // como é comum em arrays ou listas em muitas outras linguagens. Isso está relacionado ao padrão SQL,
            // onde a contagem das colunas em um banco de dados começa no 1 ao invés de 0.
            pstmt.setString(1, complete_name); // Define o valor do primeiro placeholder (complete_name)
            pstmt.setString(2, email); // Define o valor do segundo placeholder (email)
            pstmt.setString(3, telephone); // Define o valor do terceiro placeholder (telephone)
            pstmt.setString(4, username); // Define o valor do quarto placeholder (username)
            pstmt.setString(5, password); // Define o valor do quinto placeholder (password)

            // Após a consulta SQL ser executada, o número de linhas afetadas é retornado
            // O número é então armazenado nesse novo inteiro, chamado rowsAffected
            int rowsAffected = pstmt.executeUpdate(); // Executa a query de inserção

            // Exibe no console o número de linhas que foram afetadas pela query (deve ser 1 se o registro for bem-sucedido)
            // Não confundir linhas afetadas com tabelas ou colunas. Cada linha representa um usuário inteiro
            System.out.println("Linhas afetadas: " + rowsAffected);

            // Retorna 'true' se pelo menos uma linha foi afetada, indicando sucesso no registro
            return rowsAffected > 0; // Retorna 'true' se o usuário foi registrado com sucesso

            // Caso haja um erro de SQL, armazena o motivo (exceção) em "e"
        } catch (SQLException e) {
            // Então, imprime uma mensagem com o motivo do erro ("e")
            System.out.println("Erro ao registrar usuário: " + e.getMessage());
            e.printStackTrace(); // E também a pilha de chamadas, para diagnosticar o erro
            return false; // Também retorna 'false' para previnir o processo de registro de continuar
        }
    }
}