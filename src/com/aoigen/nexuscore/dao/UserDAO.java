package com.aoigen.nexuscore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/NexusCore";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; // Senha removida por questões óbvias!

    // Método para registrar um usuário no banco de dados
    public boolean registerUser(String complete_name, String email, String telephone, String username, String password) {

        System.out.println("Tentando registrar usuário...");

        String query = "INSERT INTO users (complete_name, email, telephone, username, password) VALUES (?, ?, ?, ?, ?)";

        try {
            // Tenta carregar a classe do driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Se o driver não for encontrado, exibe o erro
            System.out.println("Driver MySQL não encontrado: " + e.getMessage());
            e.printStackTrace();
        }
        

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Substitui os placeholders (?) pelos valores recebidos como argumento
            pstmt.setString(1, complete_name);
            pstmt.setString(2, email);
            pstmt.setString(3, telephone);
            pstmt.setString(4, username);
            pstmt.setString(5, password);

            // Executa a query de inserção
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("Linhas afetadas: " + rowsAffected);

            return rowsAffected > 0; // Retorna true se o usuário foi registrado com sucesso
        } catch (SQLException e) {
            System.out.println("Erro ao registrar usuário: " + e.getMessage());
            e.printStackTrace();
            return false; // Retorna false se ocorrer um erro
        }
    }
}
