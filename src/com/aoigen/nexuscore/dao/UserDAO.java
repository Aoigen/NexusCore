package com.aoigen.nexuscore.dao; // Define o pacote onde a classe será localizada

// Importando as classes necessárias para trabalhar com conexões JDBC e exceções
import java.sql.Connection; // Classe para criar e gerenciar uma conexão com o banco de dados
import java.sql.PreparedStatement; // Classe usada para executar uma consulta SQL de forma segura
import java.sql.SQLException; // Classe que representa as exceções relacionadas a erros de SQL

import com.aoigen.nexuscore.util.DatabaseConnection;

// Definindo a classe 'UserDAO', responsável por interagir com o banco de dados
// Outras classes (servlets) como por exemplo UserRegisterServlet, vão instanciar o UserDAO, que fornecerá métodos como:
// - Registro de novos usuários
// - Autenticação de usuários existentes
// - Manipulação e gerenciamento de dados de usuários
// Cada servlet vai agir como um ponto de entrada para o programa, semelhante ao método "main" em Java
// O UserDAO em si apenas fornecerá métodos, não sendo ele um servlet ou método "main"
public class UserDAO {

    // Método para validar as credenciais de login
    // Este método receberá os dados do usuário e irá consultar sua existência no banco de dados via query SQL
    public boolean validateUser(String username, String password) {

        // Criando uma instância de DatabaseConnection
        DatabaseConnection dbConnection = new DatabaseConnection();

        // Exibindo uma mensagem no console informando que o processo de registro está começando
        System.out.println("Tentando encontrar usuário...");

        // Essa String armazena a SQL que irá buscar o usuário e a senha no banco de dados
        // Ela utiliza placeholders ('?') para evitar SQL Injection, onde os valores serão substituídos mais tarde
        // Ela também otimiza consultas que são executadas várias vezes, já que elas são pré-compiladas pelo banco de dados
        String loginQuery = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";

        // Até aqui, o Driver SQL deve estar carregado e a String (loginQuery) preparada para ter seus dados substituídos...
        // A parte a seguir faz a conexão com o banco e executa a query de inserção
        try (

            Connection conn = dbConnection.getConnection();
            // 'PreparedStatement' é usado para preparar a consulta SQL de forma segura e eficiente
            // Essa classe prepara a consulta SQL usando a String "query" criada no começo, que armazena a estrutura com os placeholders
            PreparedStatement pstmt = conn.prepareStatement(loginQuery)
        ) {
            // Agora que temos o 'PreparedStatement', substituímos os placeholders (?) pelos valores fornecidos no método
            // O número 1 refere-se ao primeiro '?' na consulta SQL. O primeiro valor que será substituído é o complete_name
            // No JDBC, a indexação dos parâmetros de uma consulta SQL preparada começa em 1, ao invés de 0,
            // como é comum em arrays ou listas em muitas outras linguagens. Isso está relacionado ao padrão SQL,
            // onde a contagem das colunas em um banco de dados começa no 1 ao invés de 0.
            pstmt.setString(1, username); // Define o valor do primeiro placeholder (usarname)
            pstmt.setString(2, password); // Define o valor do segundo placeholder (password)

            // Após a consulta SQL ser executada, o número de linhas afetadas é retornado
            // O número é então armazenado nesse novo inteiro, chamado rowsAffected
            int rowsAffected = pstmt.executeUpdate(); // Executa a query de validação/busca por usuário

            // Exibe no console o número de linhas que foram afetadas pela query (deve ser 1 se o usuário for encontrado)
            // Não confundir linhas afetadas com tabelas ou colunas. Cada linha representa um usuário inteiro
            System.out.println("Linhas afetadas: " + rowsAffected);

            // Retorna 'true' se pelo menos uma linha foi afetada, indicando sucesso na busca do user
            return rowsAffected > 0; // Retorna 'true' se o usuário foi encontrado

            // Caso haja um erro de SQL, armazena o motivo (exceção) em "e"
        } catch (SQLException e) {
            // Então, imprime uma mensagem com o motivo do erro ("e")
            System.out.println("Erro ao registrar usuário: " + e.getMessage());
            e.printStackTrace(); // E também a pilha de chamadas, para diagnosticar o erro
            return false; // Também retorna 'false' para previnir o processo de registro de continuar
        }
    }

    





    // Método para registrar um usuário no banco de dados
    // Este método receberá os dados do usuário e irá inserí-los na tabela 'users' do banco de dados
    public boolean registerUser(String complete_name, String username, String email, String telephone, String password) {

        // Criando uma instância de DatabaseConnection
        DatabaseConnection dbConnection = new DatabaseConnection();

        // Exibindo uma mensagem no console informando que o processo de registro está começando
        System.out.println("Tentando registrar usuário...");

        // Essa String armazena a SQL que será executada no banco de dados para registrar o novo usuário
        // Ela utiliza placeholders ('?') para evitar SQL Injection, onde os valores serão substituídos mais tarde
        // Ela também otimiza consultas que são executadas várias vezes, já que elas são pré-compiladas pelo banco de dados
        String registerQuery = "INSERT INTO users (complete_name, username, email, telephone, password) VALUES (?, ?, ?, ?, ?)";
        
        // Até aqui, o Driver SQL deve estar carregado e a String (registerQuery) preparada para ter seus dados substituídos...
        // A parte a seguir faz a conexão com o banco e executa a query de inserção
        try (

            Connection conn = dbConnection.getConnection();
            // 'PreparedStatement' é usado para preparar a consulta SQL de forma segura e eficiente
            // Essa classe prepara a consulta SQL usando a String "query" criada no começo, que armazena a estrutura com os placeholders
            PreparedStatement pstmt = conn.prepareStatement(registerQuery)
        ) {
            // Agora que temos o 'PreparedStatement', substituímos os placeholders (?) pelos valores fornecidos no método
            // O número 1 refere-se ao primeiro '?' na consulta SQL. O primeiro valor que será substituído é o complete_name
            // No JDBC, a indexação dos parâmetros de uma consulta SQL preparada começa em 1, ao invés de 0,
            // como é comum em arrays ou listas em muitas outras linguagens. Isso está relacionado ao padrão SQL,
            // onde a contagem das colunas em um banco de dados começa no 1 ao invés de 0.
            pstmt.setString(1, complete_name); // Define o valor do primeiro placeholder (complete_name)
            pstmt.setString(2, username); // Define o valor do segundo placeholder (username)
            pstmt.setString(3, email); // Define o valor do terceiro placeholder (email)
            pstmt.setString(4, telephone); // Define o valor do quarto placeholder (telephone)
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