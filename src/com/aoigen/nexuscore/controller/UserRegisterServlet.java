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
// Ele o associa à pagina HTML que o cliente estará usando. Também poderia ser outra aplicação não-web
@WebServlet("/pages/register")
// A classe 'UserRegisterServlet' estende 'HttpServlet', que fornece a base
// para criar servlets que processam requisições HTTP (como GET e POST)
public class UserRegisterServlet extends HttpServlet { // Estende a classe HttpServlet

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

        // Mensagem no console indicando que o servlet teve sucesso em sua adição
        System.out.println("Servlet acionado.");

        // Abaixo, definimos o tipo de conteúdo da resposta como texto simples ("text/plain").
        // Isso informa ao navegador (cliente) que os dados retornados pelo servidor
        // devem ser tratados como texto puro, sem formatação (sem HTML, JSON ou outros)

        // Se não definirmos o tipo de conteúdo, o navegador pode não saber como
        // exibir corretamente a resposta ou até mesmo tratá-la de forma incorreta.
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

        // Passo 2: Validar os dados do formulário
        if (complete_name == null || complete_name.isEmpty() ||
            email == null || email.isEmpty() ||
            username == null || username.isEmpty() ||
            password == null || password.isEmpty()) {
            // Se algum campo obrigatório estiver vazio, envia uma mensagem de erro
            response.getWriter().println("Por favor, preencha todos os campos obrigatórios.");
            return; // Interrompe a execução
        }

    // Regex para validar o nome completo: entre 3 e 50 caracteres, podendo conter letras (acentuadas ou não) e espaços
    String regexCompleteName = "^[a-zA-ZÀ-ÿ\\s]{3,50}$";

    // Regex para validar o nome de usuário: entre 3 e 15 caracteres, contendo apenas letras, números ou _
    String regexUsername = "^[a-zA-Z0-9_]{3,15}$";

    // Regex para validar o e-mail: formato 'exemplo@dominio.com'
    String regexEmail = "^[\\w-\\.]+@[a-zA-Z0-9-]+\\.[a-z]{2,}$";

    // Regex para validar o telefone: suporta números com ou sem o sinal de "+" no início, com 8 a 15 dígitos
    String regexTelephone = "^\\+?\\d{8,15}$";

    // Regex para validar a senha: pelo menos 8 caracteres, incluindo uma letra, um número e um caractere especial (@$!%*?&)
    String regexPassword = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        // Verificar se o nome completo é válido
        if (!complete_name.matches(regexCompleteName)) {
            response.getWriter().println("O nome completo deve ter entre 3 e 50 caracteres, contendo apenas letras e espaços.");
            return; // Interrompe a execução
        }

        // Verificar se o nome de usuário é válido
        if (!username.matches(regexUsername)) {
            response.getWriter().println("O nome de usuário deve ter entre 3 e 15 caracteres, contendo apenas letras, números ou '_'.");
            return; // Interrompe a execução
        }

        // Verificar se o e-mail é válido
        if (!email.matches(regexEmail)) {
            response.getWriter().println("Por favor, insira um e-mail válido.");
            return; // Interrompe a execução
        }

        // Verificar se o telefone é válido
        if (!password.matches(regexTelephone)) {
            response.getWriter().println("O telefone suporta números com ou sem o sinal de \"+\" no início, com 8 a 15 dígitos");
            return; // Interrompe a execução
        }

        // Verificar se a senha é válida
        if (!password.matches(regexPassword)) {
            response.getWriter().println("A senha deve ter pelo menos 8 caracteres, incluindo uma letra, um número e um caractere especial.");
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