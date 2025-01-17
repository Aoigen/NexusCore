package com.aoigen.nexuscore.controller;

// Importações necessárias para o funcionamento do servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Importa o UserDAO para interagir com o banco de dados
import com.aoigen.nexuscore.dao.UserDAO;

// A anotação @WebServlet define o endpoint para este servlet
@WebServlet("/pages/register")
public class UserRegisterServlet extends HttpServlet {

    // Este método doPost é chamado quando o formulário HTML usa o método "POST"
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

                System.out.println("Servlet acionado.");

        // Define o tipo de conteúdo da resposta como texto simples
        response.setContentType("text/plain");

        // Passo 1: Capturar os dados enviados pelo formulário HTML
        // O método getParameter pega os valores dos campos de formulário
        String complete_name = request.getParameter("complete_name");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Dados recebidos:");
        System.out.println("Complete Name: " + complete_name);
        System.out.println("Email: " + email);
        System.out.println("Telephone: " + telephone);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Passo 2: Validar os dados do formulário (exemplo básico)
        if (complete_name == null || complete_name.isEmpty() ||
            email == null || email.isEmpty() ||
            username == null || username.isEmpty() ||
            password == null || password.isEmpty()) {
            // Se algum campo obrigatório estiver vazio, envia uma mensagem de erro
            response.getWriter().println("Por favor, preencha todos os campos obrigatórios.");
            return; // Interrompe a execução
        }

        // Passo 3: Interagir com o banco de dados através do UserDAO
        UserDAO userDAO = new UserDAO(); // Cria uma instância do DAO
        boolean isRegistered = userDAO.registerUser(complete_name, email, telephone, username, password);

        // Passo 4: Enviar uma resposta de acordo com o resultado da operação
        if (isRegistered) {
            // Se o registro for bem-sucedido, envia uma mensagem de sucesso
            response.getWriter().println("Usuário registrado com sucesso!");
        } else {
            // Caso contrário, envia uma mensagem de erro
            response.getWriter().println("Erro ao registrar o usuário. Tente novamente.");
        }
    }
}