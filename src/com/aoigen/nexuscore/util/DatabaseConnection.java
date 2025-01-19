package com.aoigen.nexuscore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Definindo constantes para armanezar as credencias de conexão com o banco de dados
    // Em ambientes corporativos, para mais segurança, podemos armazenar esses dados em arquivos .properties ou usar bibliotecas para criptografar esses dados
    // Este é um projeto acadêmico e não possui essa necessidade
    // Portanto, sempre remova as credênciais antes de empurrar isso em repositórios ou outros lugares na web
    private static final String DB_URL = "jdbc:mysql://localhost:3306/NexusCore"; // URL do banco de dados MySQL
    private static final String DB_USER = "root"; // Usuário do banco de dados
    private static final String DB_PASSWORD = "x"; // Senha do banco de dados (vazia neste caso)

    public Connection getConnection() throws SQLException {

        try {
            // Tentando (try) carregar a classe do driver JDBC do MySQL
            // Essa classe é necessária para que o Java saiba como se comunicar com o banco de dados MySQL
            // É nessa parte que escolhemos qual será o banco de dados utilizado. O Nexus Core utilizará MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carrega o driver do MySQL para se comunicar com o JDBC
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // Conecta ao banco de dados

        } catch (ClassNotFoundException e) {
            // Se o driver não for encontrado, armazena o motivo em "e", exibindo uma mensagem de erro e
            // imprimindo a stack trace (pilha de chamadas) para diagnosticar o erro
            System.out.println("Driver MySQL não encontrado: " + e.getMessage()); // Exibe o motivo do erro.
            e.printStackTrace(); // Imprime a pilha de chamadas (stack trace) no console, ajudando no diagnóstico do erro.

            // Lança uma exceção indicando que a conexão não foi possível
            throw new SQLException("Erro ao carregar o driver JDBC", e);

        }
    }

}
