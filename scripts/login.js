// Seleciona o campo de entrada de senha pelo ID 'inputPassword'.
const inputPassword = document.getElementById('inputPassword');

// Seleciona o botão de alternância de visibilidade de senha pelo ID 'togglePassword'.
const togglePassword = document.getElementById('togglePassword');

// Verifica se o botão e o campo de senha existem antes de adicionar o ouvinte.
if (inputPassword && togglePassword) {
    togglePassword.addEventListener('click', function () {
        
        // Verifica o atributo 'type' do campo de senha.
        if (inputPassword.type === 'password') {
            // Altera o tipo do campo para 'text' para que a senha fique visível.
            inputPassword.type = 'text';
        } else {
            // Altera o tipo de volta para 'password' para ocultar a senha.
            inputPassword.type = 'password';
        }
    });
}