/*
    Este é um arquivo de JavaScript (.js).
    Aqui, iremos aprender a definir a lógica e o comportamento dinâmico de uma página web,
    como validação de formulários, manipulação de eventos e interações com o DOM.
*/

/*
                                    Seletores e Manipulação do DOM no JavaScript:

    No JavaScript, podemos acessar e manipular os elementos HTML usando diferentes métodos de seleção.
    Aqui estão alguns dos métodos mais comuns:
*/

/*
    1. Selecionar elementos pelo ID:
    Utiliza o método `getElementById` para selecionar um único elemento pelo seu atributo "id".

    Exemplo:
    
    const inputEmail = document.getElementById('inputEmail');
    // Seleciona o elemento <input> com o id "inputEmail".
*/

 /*
    2. Selecionar elementos pela classe:
    O método `getElementsByClassName` retorna uma coleção de todos os elementos com uma classe específica.

    Exemplo:
    
    const divs = document.getElementsByClassName('container');
    // Seleciona todos os elementos <div> com a classe "container".
*/

 /*
    3. Selecionar elementos pelo nome da tag:
    Utilizando `getElementsByTagName`, podemos selecionar todos os elementos de uma determinada tag HTML.

    Exemplo:
    
    const paragraphs = document.getElementsByTagName('p');
    // Seleciona todos os elementos <p> na página.
*/

 /*
    4. Seleção mais flexível com querySelector:
    O método `querySelector` permite selecionar elementos com base em seletores CSS, oferecendo flexibilidade.

    Exemplo:
    
    const firstButton = document.querySelector('button');
    // Seleciona o primeiro botão encontrado na página.
*/

 /*
    5. Seleção de múltiplos elementos com querySelectorAll:
    Semelhante ao `querySelector`, mas retorna todos os elementos que correspondem ao seletor.

    Exemplo:
    
    const allButtons = document.querySelectorAll('button');
    // Seleciona todos os elementos <button> na página.
*/

/*
                                            Manipulação de Elementos:

    Podemos modificar propriedades, conteúdos e atributos dos elementos diretamente por JavaScript.
*/

/*
    1. Modificando o conteúdo de um elemento:
    Utilizando a propriedade `textContent` ou `innerHTML`, podemos alterar o conteúdo de texto ou HTML de um elemento.

    Exemplo:

    const heading = document.getElementById('title');
    heading.textContent = 'Novo Título';
    // Altera o texto da tag <h1> com o id "title" para "Novo Título".
*/

 /*
    2. Modificando o estilo de um elemento:
    Podemos alterar as propriedades de estilo de um elemento diretamente usando a propriedade `style`.

    Exemplo:
    
    const button = document.getElementById('submitButton');
    button.style.backgroundColor = 'green';
    // Altera a cor de fundo do botão para verde.
*/

 /*
    3. Modificando atributos de um elemento:
    Podemos alterar atributos HTML de um elemento usando os métodos `setAttribute` e `getAttribute`.

    Exemplo:

    const link = document.getElementById('myLink');
    link.setAttribute('href', 'https://www.example.com');
    // Altera o atributo "href" do link para o novo URL.
*/

 /*
    4. Remover elementos da página:
    O método `removeChild` permite remover um elemento filho de um nó pai.

    Exemplo:
    
    const parent = document.getElementById('container');
    const child = document.getElementById('element');
    parent.removeChild(child);
    // Remove o elemento com o id "element" da div "container".
*/

/*
                                            Eventos no JavaScript:

    Em JavaScript, eventos permitem interações dinâmicas com a página.
    Podemos escutar e reagir a ações do usuário, como cliques, teclas pressionadas, entre outros.
*/

/*
    1. Adicionar um evento de clique:
    Usamos o método `addEventListener` para associar um evento (como "click") a um elemento.

    Exemplo:

    const button = document.getElementById('submitButton');
    button.addEventListener('click', function() {
        alert('Botão clicado!');
    });
    // Exibe um alerta quando o botão é clicado.
*/

 /*
    2. Adicionar um evento de foco (focus):
    Podemos executar uma ação quando um campo de formulário recebe o foco.

    Exemplo:
    
    const input = document.getElementById('inputField');
    input.addEventListener('focus', function() {
        input.style.borderColor = 'blue';
    });
    // Altera a cor da borda do campo para azul quando ele recebe o foco.
*/

 /*
    3. Adicionar um evento de digitação (input):
    Acompanhamos as entradas do usuário em tempo real com o evento `input`.

    Exemplo:
    
    const input = document.getElementById('nameField');
    input.addEventListener('input', function() {
        console.log(input.value);
    });
    // Exibe o valor digitado no campo de entrada no console enquanto o usuário digita.
*/

/*
                                            Validação de Formulários:

    Validar formulários ajuda a garantir que os dados inseridos são corretos antes de enviá-los ao servidor.
    Vamos ver como validar campos de texto usando expressões regulares (regex).
*/

/*
    1. Expressão regular para validar e-mail:
    Podemos usar expressões regulares para verificar se o valor de um campo de e-mail tem o formato correto.

    Exemplo:
    
    const email = document.getElementById('emailField');
    const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    email.addEventListener('input', function() {
        if (!regexEmail.test(email.value)) {
            email.style.borderColor = 'red';
        } else {
            email.style.borderColor = 'green';
        }
    });
    // Verifica se o e-mail é válido e altera a cor da borda.
*/

 /*
    2. Validação de senha:
    A senha pode ter requisitos de complexidade, como incluir letras maiúsculas, minúsculas, números e caracteres especiais.

    Exemplo:

    const password = document.getElementById('passwordField');
    const regexPassword = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    password.addEventListener('input', function() {
        if (!regexPassword.test(password.value)) {
            password.style.borderColor = 'red';
        } else {
            password.style.borderColor = 'green';
        }
    });
    // Valida se a senha é forte o suficiente e altera a cor da borda.
*/

/*
                                            Funções no JavaScript:

    Funções em JavaScript são blocos de código reutilizáveis que podem ser chamados para executar ações específicas.
*/

/*
    1. Definindo uma função simples:
    As funções podem ser declaradas usando a palavra-chave `function`.

    Exemplo:

    function greet() {
        console.log('Hello, World!');
    }
    greet(); // Exibe "Hello, World!" no console.
*/

 /*
    2. Função com parâmetros e retorno:
    Podemos passar dados para uma função e receber um valor de retorno.

    Exemplo:

    function sum(a, b) {
        return a + b;
    }
    console.log(sum(3, 4)); // Exibe 7 no console.
*/

 /*
    3. Função anônima e arrow function:
    Uma função anônima é uma função sem nome, muitas vezes usada em callbacks ou como funções de uma linha.

    Exemplo de arrow function:
    
    const multiply = (a, b) => a * b;
    console.log(multiply(2, 3)); // Exibe 6 no console.
*/

/*
                                            Trabalhando com Arrays:

    Arrays são estruturas de dados que permitem armazenar múltiplos valores em uma única variável.
*/

/*
    1. Criando um array:
    Podemos criar um array utilizando colchetes (`[]`).

    Exemplo:

    const numbers = [1, 2, 3, 4, 5];
    // Cria um array contendo os números de 1 a 5.
*/

 /*
    2. Acessando elementos do array:
    Podemos acessar elementos de um array usando o índice, que começa em 0.

    Exemplo:
    
    console.log(numbers[0]); // Exibe 1 no console.
    console.log(numbers[2]); // Exibe 3 no console.
*/

 /*
    3. Adicionando e removendo elementos:
    Usamos métodos como `push` para adicionar elementos e `pop` para remover elementos.

    Exemplo:

    numbers.push(6); // Adiciona o número 6 no final do array.
    numbers.pop(); // Remove o último elemento do array.
*/

/*
    4. Iterando sobre um array:
    Podemos usar métodos como `forEach` para percorrer todos os elementos de um array.

    Exemplo:
    
    numbers.forEach(function(number) {
        console.log(number);
    });
    // Exibe todos os números do array no console.
*/