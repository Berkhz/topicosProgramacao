let xBolinha = 300;
let yBolinha = 200;
let diametro = 20;
let vxBolinha = 5;
let vyBolinha = 5;
let raio = diametro / 2;

let xRacket1 = 10;
let yRacket1 = 150;
let xRacket2 = 580;
let yRacket2 = 150;
let larguraRacket = 10;
let alturaRacket = 100;
let velocidadeRacket = 8;

let pontos1 = 0;
let pontos2 = 0;
let incrementoVelocidade = 0.1;
let limitePontos = 3;

function setup() {
    createCanvas(600, 400);
}

function draw() {
    background(0);
    
    mostrarPlacar();
    
    criarBolinha();
    movimentarBolinha();
    validarColisaoBorda();
    
    criarRaquete(xRacket1, yRacket1);
    criarRaquete(xRacket2, yRacket2);
    
    movimentarRaqueteJogador();
    movimentarRaqueteInimiga();
    
    verificarColisaoRaquete(xRacket1, yRacket1);
    verificarColisaoRaquete(xRacket2, yRacket2);

    verificarVencedor();
}

function criarBolinha() {
    circle(xBolinha, yBolinha, diametro);
}

function movimentarBolinha() {
    xBolinha += vxBolinha;
    yBolinha += vyBolinha;
}

function validarColisaoBorda() {
    if (yBolinha + raio > height || yBolinha - raio < 0) {
        vyBolinha *= -1;
    }
    
    if (xBolinha - raio < 0) {
        pontos2++;
        resetBolinha();
    }
    
    if (xBolinha + raio > width) {
        pontos1++;
        resetBolinha();
    }
}

function criarRaquete(x, y) {
    rect(x, y, larguraRacket, alturaRacket);
}

function movimentarRaqueteJogador() {
    if (keyIsDown(UP_ARROW)) {
        yRacket1 -= velocidadeRacket;
    }
    if (keyIsDown(DOWN_ARROW)) {
        yRacket1 += velocidadeRacket;
    }
    yRacket1 = constrain(yRacket1, 0, height - alturaRacket);
}

function movimentarRaqueteInimiga() {
    let centroRaquete2 = yRacket2 + alturaRacket / 2;
    if (centroRaquete2 < yBolinha - 20) {
        yRacket2 += velocidadeRacket;
    } else if (centroRaquete2 > yBolinha + 20) {
        yRacket2 -= velocidadeRacket;
    }
    yRacket2 = constrain(yRacket2, 0, height - alturaRacket);
}

function verificarColisaoRaquete(x, y) {
    if (
        xBolinha - raio < x + larguraRacket &&
        xBolinha + raio > x &&
        yBolinha + raio > y &&
        yBolinha - raio < y + alturaRacket
    ) {
        vxBolinha *= -1;
        vxBolinha += vxBolinha > 0 ? incrementoVelocidade : -incrementoVelocidade;
        vyBolinha += vyBolinha > 0 ? incrementoVelocidade : -incrementoVelocidade;
    }
}

function resetBolinha() {
    xBolinha = width / 2;
    yBolinha = height / 2;
    vxBolinha = 5 * (random() > 0.5 ? 1 : -1);
    vyBolinha = 5 * (random() > 0.5 ? 1 : -1);
}

function verificarVencedor() {
    if (pontos1 >= limitePontos || pontos2 >= limitePontos) {
        pontos1 = 0;
        pontos2 = 0;
        resetBolinha();
    }
}

function mostrarPlacar() {
    fill(255);
    textSize(20);
    textAlign(CENTER);
    text(pontos1, width / 4, 30);
    text(pontos2, (3 * width) / 4, 30);
}