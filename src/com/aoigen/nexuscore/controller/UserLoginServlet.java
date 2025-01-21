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

// A anotação @WebServlet define o endpoint para este servlet, fazendo-o se comportar parecido com o que conhecemos como método "main" no Java
// Ele o associa à pagina HTML que o cliente estará usando ou a outras aplicações
@WebServlet("/pages/login")
// A classe 'UserLoginServlet' estende 'HttpServlet', que fornece a base
// para criar servlets que processam requisições HTTP (como GET e POST)
public class UserLoginServlet extends HttpServlet { //Estende a classe HttpServlet

    // Este método doPost é chamado quando o formulário HTML usa o método "POST"
    // A anotação @Override indica que este método está sobrescrevendo
    // o comportamento padrão definido na classe HttpServlet.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        // A cláusula 'throws ServletException, IOException' avisa que este método 
        // pode enfrentar problemas enquanto processa a requisição (por exemplo, 
        // erros no servidor ou ao ler dados do cliente). Quando isso acontece, 
        // o Tomcat (contêiner) é quem cuida desses erros, enviando uma resposta 
        // apropriada para o cliente (como um código de erro HTTP ou página web personalizada, dependendo da configuração)
    throws ServletException, IOException {

        // Mensagem no console indicando que o servlet teve sucesso em sua ativação
        System.out.println("Servlet acionado.");

        // Abaixo, definimos o tipo de conteúdo da resposta como texto simples ("text/plain").
        // Isso informa ao navegador (cliente) que os dados retornados pelo servidor
        // devem ser tratados como texto puro, sem formatação (sem HTML, JSON ou outros)

        // Se não definirmos o tipo de conteúdo, o navegador pode não saber como
        // exibir corretamente a resposta ou até mesmo tratá-la de forma incorreta.
        response.setContentType("text/plain");

        // Passo 1: Capturar os dados enviados pelo formulário HTML e armazená-los em Strings
        // O método getParameter pega os valores dos campos de formulário
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Dados recebidos:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Passo 2: Interagir com o banco de dados através do UserDAO
        // É aqui que ele vai validar a existencia do user no banco de dados
        UserDAO userDAO = new UserDAO(); // Cria uma instância do DAO
        boolean isRegistered = userDAO.validateUser(username, password);

        // Passo 3: Enviar uma resposta de acordo com o resultado da operação
        if (isRegistered) {
            // Se a busca for bem-sucedido, envia uma mensagem de sucesso
            response.getWriter().println("Usuário encontrado com sucesso!");
        } else {
            // Caso contrário, envia uma mensagem de erro
            response.getWriter().println("Erro ao encontrar usuário. Tente novamente.");
        }

    }
}