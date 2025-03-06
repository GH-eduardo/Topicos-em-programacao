// Variáveis da bolinha
let xBolinha = 300;
let yBolinha = 190;
let diametro = 10;
let VxBolinha = -5;
let VyBolinha = -5;
let raio = diametro/2;

// Variáveis das raquetes
let xRaquete = 10;
let yRaquete = 155;
let xRaquete2 = 585;
let yRaquete2 = 155;
let comprimentoRaquete = 90;
let larguraRaquete = 5;

// Variáveis dos jogadores
let pontosJogadorA = 0;
let pontosJogadorB = 0;
let nomeJogadorA = "";
let nomeJogadorB = "";

// Criar o conteúdo da página dinamicamente quando o documento for carregado
document.addEventListener('DOMContentLoaded', function() {
    // Criar e configurar o elemento principal
    const app = document.createElement('div');
    app.id = 'app';
    document.body.appendChild(app);

    // Adicionar estilos diretamente no JavaScript
    const style = document.createElement('style');
    style.textContent = `
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
            flex-wrap: wrap;
            flex-direction: column;
        }
        #botaoJogar {
            padding: 20px 40px;
            font-size: 24px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        #botaoJogar:hover {
            background-color: #ffcc00; /* Laranja claro */
        }
        #formulario {
            display: none;
            flex-direction: column;
            align-items: center;
        }
        #formulario input {
            width: 24vw;
            margin: 10px;
            padding: 10px;
            font-size: 18px;
        }
        #formulario button {
            padding: 10px 20px;
            font-size: 18px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
    `;
    document.head.appendChild(style);

    // Criar o botão "Jogar Pong"
    const botaoJogar = document.createElement('button');
    botaoJogar.id = 'botaoJogar';
    botaoJogar.textContent = 'Jogar Pong';
    app.appendChild(botaoJogar);

    // Criar o formulário
    const formulario = document.createElement('form');
    formulario.id = 'formulario';
    formulario.innerHTML = `
        <input type="text" id="jogadorA" placeholder="Nome do jogador A (jogue com 'W' e 'S')">
        <input type="text" id="jogadorB" placeholder="Nome do jogador B (jogue com seta para cima e para baixo)">
        <button type="submit">Iniciar Jogo</button>
    `;
    app.appendChild(formulario);

    // Adicionar evento de clique ao botão
    botaoJogar.addEventListener('click', function() {
        botaoJogar.style.display = 'none'; // Esconde o botão
        formulario.style.display = 'flex'; // Mostra o formulário
    });

    // Adiciona o evento de submit
    formulario.addEventListener('submit', function(event) {
        event.preventDefault(); // Impede o recarregamento da página

        // Pega os valores dos campos do formulário
        nomeJogadorA = document.getElementById('jogadorA').value;
        nomeJogadorB = document.getElementById('jogadorB').value;

        app.style.display = 'none'; // Esconde o elemento app
        document.querySelector(`#defaultCanvas0`).style.display = 'flex';
        loop();
    });
});

function setup() {
    createCanvas(600.0, 400.0)
    noLoop();
}

function draw() {
    background(0)
    circle(xBolinha, yBolinha, diametro)
    rect(xRaquete, yRaquete, larguraRaquete, comprimentoRaquete)
    rect(xRaquete2, yRaquete2, larguraRaquete, comprimentoRaquete)
    moverRaquetes()
    fill(230,230,230)
    textSize(40)
    text(pontosJogadorA.toString(), 270, 50)
    text(pontosJogadorB.toString(), 330, 50)
}

function moverRaquetes() {

        xBolinha += VxBolinha;
        yBolinha += VyBolinha

        limites()

        if( keyIsDown(87) === true ) {
            yRaquete -= 5;
        }

        if( keyIsDown(83) === true ) {
            yRaquete += 5;
        }

        if( keyIsDown(UP_ARROW) === true ) {
            yRaquete2 -= 5;
        }

        if( keyIsDown(DOWN_ARROW) === true ) {
            yRaquete2 += 5;
        }

}

function limites() {

        if (xBolinha + raio > 600){
            pontuar("A")
        }   

        if (xBolinha - raio < 0){
            pontuar("B")
        }

        if (yBolinha + raio > 400 || yBolinha - raio < 0){
            VyBolinha *= -1;
        } // Limites verticais para a bolinha


        if (xBolinha - raio == xRaquete+larguraRaquete && (yBolinha+raio >= yRaquete) && (yBolinha+raio <= yRaquete + comprimentoRaquete) ) {
            VxBolinha *= -1;
        } // Limite para quando a bolinha bate na raquete da esquerda

        if (xBolinha + raio == xRaquete2 && (yBolinha+raio >= yRaquete2) && (yBolinha+raio <= yRaquete2 + comprimentoRaquete) ) {
            VxBolinha *= -1;
        } // Limite para quando a bolinha bate na raquete da direita


        if (yRaquete <= 5) {
            yRaquete = 5;
        } // Limite de cima para a raquete da esquerda

        if (yRaquete + comprimentoRaquete >= 395) {
            yRaquete = 395 - comprimentoRaquete;
        } // Limite de baixo para raquete da esquerda

        if (yRaquete2 <= 5) {
            yRaquete2 = 5;
        } // Limite de cima para a raquete da direita

        if (yRaquete2 + comprimentoRaquete >= 395) {
            yRaquete2 = 395 - comprimentoRaquete;
        } // Limite de baixo para a raquete da direita

}

function pontuar(jogador) {
    if (jogador === "A") {
        pontosJogadorA++;
        if (pontosJogadorA == 10) {
            winnerPage()
        }
    }
    else {
        pontosJogadorB++;
        if (pontosJogadorB == 10) {
            winnerPage()
        }
    }
    resetGame();
}

function resetGame() {
    xBolinha = 300;
    yBolinha = 190;
}

function winnerPage() {

    document.querySelector(`#defaultCanvas0`).style.display = 'none';

    let vencedor = "";
    let maior;
    let menor;

    if (pontosJogadorA > pontosJogadorB) {
        vencedor = nomeJogadorA;
        maior = pontosJogadorA;
        menor = pontosJogadorB;
    }
    else {
        vencedor = nomeJogadorB;
        menor = pontosJogadorA;
        maior = pontosJogadorB;
    }
    let h1 = document.createElement('h1');
    h1.innerHTML = `
    <h1>   ${vencedor} Ganhou!!!<br>Placar Final: ${maior} X ${menor}</h1>
    `
    document.body.appendChild(h1);

    // Criar o botão "Jogar Pong"
    const botaoReload = document.createElement('button');
    botaoReload.id = 'botaoReload';
    botaoReload.innerHTML = `<i class="fas fa-sync-alt"></i>`
    document.body.appendChild(botaoReload);

    // Adicionar evento de clique ao botão
    botaoReload.addEventListener('click', function() {
        location.reload();
    });

}