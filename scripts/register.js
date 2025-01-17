// Vamos começar selecionando os elementos do formulário HTML e criando os padrões de validação (Regex).
// Em caso de dúvida, por favor, consultar o README.js.

// 1. Criando constantes e Regex para atribuí-los aos seus respectivos <input>s no HTML.
const inputCompleteName = document.getElementById('inputCompleteName'); // Atribuindo o <input> na nossa nova const.
const regexCompleteName = /^[a-zA-ZÀ-ÿ]+(?:[-' ][a-zA-ZÀ-ÿ]+)+$/; // Regex para omes compostos com letras, espaços, hífens ou apóstrofos.

// O mesmo vale para os outros campos de entrada:

const inputUsername = document.getElementById('inputUsername');
const regexUsername = /^[a-zA-Z0-9_.@]{6,}$/;
// Regex para validar o nome de usuário: deve ter pelo menos 6 caracteres e pode conter letras, números, underscores (_), pontos (.) e @.

const inputEmail = document.getElementById('inputEmail');
const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
// Regex para validar o email: deve ter o formato 'exemplo@dominio.com'.

const inputTelephone = document.getElementById('inputTelephone');
const regexTelephone = /^\+?\d{8,15}$/;
// Regex para validar o telefone: suporta números com ou sem o sinal de "+" no início, com 8 a 15 dígitos.

const inputPassword = document.getElementById('inputPassword');
const regexPassword = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
// Regex para senha forte: deve ter pelo menos 8 caracteres e incluir pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial.

const inputConfirmPassword = document.getElementById('inputConfirmPassword');
// O campo de confirmação de senha não precisa de regex, apenas validação simples (se as senhas coincidirem).



// 2. Botões de exibição/ocultação de senha
const buttonTogglePassword = document.getElementById('togglePassword');
const buttonToggleConfirmPassword = document.getElementById('toggleConfirmPassword');



// 3. Seleção de uma div para exibir informações de validação (exemplo: "campo inválido").
// `querySelector` seleciona o primeiro elemento que corresponde ao seletor CSS passado (nesse caso, a div com a classe 'inputInfo').
const inputInfoDiv = document.querySelector('.inputInfo');



// 4. Função para atualizar a descrição informativa do campo.
function updateInputDescription(text) {
    const aboutInput = document.getElementById('aboutInput');
    aboutInput.textContent = text; // `textContent` atualiza o conteúdo textual do elemento.
}



// 5. Função de validação.
// A função `validateInput` verifica se o campo de entrada está vazio ou não corresponde ao padrão da regex.
function validateInput(input, regex) {
    // `trim()` remove espaços extras do começo e final do texto.
    if (input.value.trim() === "" || !regex.test(input.value)) {
        aboutInput.style.color = "red"; // Deixa a cor vermelha para indicar erro.
        return false;                   // Retorna `false` se a validação falhar.
    } else {
        aboutInput.style.color = "azure"; // Retorna ao estilo padrão (azure) se válido.
        return true;                      // Retorna `true` se a validação for bem-sucedida.
    }
}



// 6. Eventos de validação em tempo real com `addEventListener`.
// Cada vez que o usuário digitar no campo `inputCompleteName`, a função `validateInput` será chamada para validar o nome completo.
inputCompleteName.addEventListener('input', () => validateInput(inputCompleteName, regexCompleteName));
// O mesmo acontece para os outros campos: username, email, telefone e senha.
inputUsername.addEventListener('input', () => validateInput(inputUsername, regexUsername));
inputEmail.addEventListener('input', () => validateInput(inputEmail, regexEmail));
inputTelephone.addEventListener('input', () => validateInput(inputTelephone, regexTelephone));
inputPassword.addEventListener('input', () => validateInput(inputPassword, regexPassword));



// 7. Validação para o campo de nome completo.
inputCompleteName.addEventListener('input', () => {
    // Quando o usuário digitar no campo de nome completo, verificamos se ele não está vazio ou não corresponde ao regex.
    if (inputCompleteName.value.trim() === "" || !regexCompleteName.test(inputCompleteName.value)) { // Se for inválido...
        inputCompleteName.style.color = "red";                  // Deixa a cor do texto vermelha para indicar erro.
    } else {                                                    // Se for válido...
        inputCompleteName.style.color = "";                     // Devolve a cor padrão.
    }
});

// O mesmo vale para outros campos

// Validação para o campo de nome de usuário.
inputUsername.addEventListener('input', () => {
    // Quando o usuário digitar no campo de nome de usuário, verificamos se ele não está vazio ou não corresponde ao regex.
    if (inputUsername.value.trim() === "" || !regexUsername.test(inputUsername.value)) { // Se for inválido...
        inputUsername.style.color = "red";                      // Deixa a cor do texto vermelha para indicar erro.
    } else {                                                    // Se for válido...
        inputUsername.style.color = "";                         // Devolve a cor padrão.
    }
});

// Validação para o campo de e-mail.
inputEmail.addEventListener('input', () => {
    // Quando o usuário digitar no campo de e-mail, verificamos se ele não está vazio ou não corresponde ao regex.
    if (inputEmail.value.trim() === "" || !regexEmail.test(inputEmail.value)) { // Se for inválido...
        inputEmail.style.color = "red";                          // Deixa a cor do texto vermelha para indicar erro.
    } else {                                                     // Se for válido...
        inputEmail.style.color = "";                             // Devolve a cor padrão.
    }
});

// Validação para o campo de telefone.
inputTelephone.addEventListener('input', () => {
    // Quando o usuário digitar no campo de telefone, verificamos se ele não está vazio ou não corresponde ao regex.
    if (inputTelephone.value.trim() === "" || !regexTelephone.test(inputTelephone.value)) { // Se for inválido...
        inputTelephone.style.color = "red";                      // Deixa a cor do texto vermelha para indicar erro.
    } else {                                                     // Se for válido...
        inputTelephone.style.color = "";                         // Devolve a cor padrão.
    }
});

// Validação para o campo de senha.
inputPassword.addEventListener('input', () => {
    // Quando o usuário digitar no campo de senha, verificamos se ele não está vazio ou não corresponde ao regex.
    if (inputPassword.value.trim() === "" || !regexPassword.test(inputPassword.value)) { // Se for inválido...
        inputPassword.style.color = "red";                       // Deixa a cor do texto vermelha para indicar erro.
    } else {                                                     // Se for válido...
        inputPassword.style.color = "";                          // Devolve a cor padrão.
    }
});

// Validação para o campo de confirmação de senha.
inputConfirmPassword.addEventListener('input', () => {
    // Quando o usuário digitar no campo de confirmação de senha, verificamos se ela é igual à senha principal.
    if (inputConfirmPassword.value !== inputPassword.value) { // Se for diferente...
        inputPassword.style.color = "red";                    // Deixa a cor da senha vermelha para indicar erro.
    } else {                                                  // Se as senhas forem iguais...
        inputPassword.style.color = "";                       // Devolve a cor padrão.
    }
});




// 8. Eventos de foco para exibir descrições úteis para o usuário quando ele clicar no campo.
// Quando o campo `inputCompleteName` recebe foco, a função `updateInputDescription` é chamada com uma descrição sobre o que é esperado nesse campo.
inputCompleteName.addEventListener('focus', () => {
    updateInputDescription("Digite seu nome completo. Deve conter pelo menos dois nomes e pode incluir hifens ou apóstrofos.");
});

// O mesmo vale para os outros campos: username, email, telefone, senha e confirmação de senha.

inputUsername.addEventListener('focus', () => {
    updateInputDescription("Escolha um nome de usuário. Deve ter no mínimo 6 caracteres e pode incluir letras, números, underscores (_), pontos (.) e @.");
});
inputEmail.addEventListener('focus', () => {
    updateInputDescription("Digite seu endereço de e-mail. Certifique-se de que seja um formato válido, como exemplo@dominio.com.");
});
inputTelephone.addEventListener('focus', () => {
    updateInputDescription("Insira seu número de telefone com o código do país. Exemplo: +5511912345678.");
});
inputPassword.addEventListener('focus', () => {
    updateInputDescription("Crie uma senha forte. Deve ter no mínimo 8 caracteres, incluindo uma letra maiúscula, uma letra minúscula, um número e um caractere especial.");
});
inputConfirmPassword.addEventListener('focus', () => {
    updateInputDescription("Confirme sua senha. Ela deve ser idêntica à senha criada acima.");
});



// 9. Retorna ao texto original quando o campo perde o foco (evento 'blur').
// Para todos os campos de entrada, o evento 'blur' é usado para definir o texto de descrição padrão quando o usuário sai do campo.
document.querySelectorAll('input').forEach(input => {
    input.addEventListener('blur', () => {
        updateInputDescription("Esse é um projeto acadêmico, portanto, não insira dados reais neste formulário.");
    });
});



// 10. Função para alternar a visibilidade da senha.
// A função `togglePasswordVisibility` altera o tipo do campo de senha de 'password' para 'text' e vice-versa.
function togglePasswordVisibility(input, button) {
    button.addEventListener('click', () => {
        if (input.type === "password") { // Se o tipo de input for "password", então...
            input.type = "text";         // Mostramos a senha, mudando o tipo de campo para "text".
        } else {                         // Se o tipo de input já for "text"...
            input.type = "password";     // Ocultamos a senha, mudando o tipo de campo para "password".
        }
    });
}



// 11. Chamando a função de alternância de senha para os campos de senha.
togglePasswordVisibility(inputPassword, buttonTogglePassword);
togglePasswordVisibility(inputConfirmPassword, buttonToggleConfirmPassword);



// Função para verificar todos os campos antes de enviar o formulário.
function validateAllInputs() {
    const isCompleteNameValid = validateInput(inputCompleteName, regexCompleteName);
    const isUsernameValid = validateInput(inputUsername, regexUsername);
    const isEmailValid = validateInput(inputEmail, regexEmail);
    const isTelephoneValid = validateInput(inputTelephone, regexTelephone);
    const isPasswordValid = validateInput(inputPassword, regexPassword);
    
    // Se algum campo for inválido, retorna false
    if (!isCompleteNameValid || !isUsernameValid || !isEmailValid || !isTelephoneValid || !isPasswordValid || !isConfirmPasswordValid) {
        return false;
    }
    return true;
}

// Evento de submit para impedir o envio do formulário caso algo esteja inválido
const form = document.querySelector('form');  // Selecione o formulário
form.addEventListener('submit', (event) => {
    // Verifique se todos os campos estão válidos antes de enviar
    if (!validateAllInputs()) {
        event.preventDefault();  // Impede o envio
        alert("Por favor, preencha todos os campos corretamente.");
    }
});
