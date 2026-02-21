package campo_minado.test.br.com.cod3r.cm.model;

import campo_minado.src.br.com.cod3r.cm.model.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTeste {

    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
    void testeVizinhoDistancia1Esquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    void testeVizinhoDistancia1Direita() {
        Campo vizinho = new Campo(3, 4);
        boolean reusltado = campo.adicionarVizinho(vizinho);
        assertTrue(reusltado);
    }

    @Test
    void testeVizinhoDistancia1EmCima() {
        Campo vizinho = new Campo(2, 3);
        boolean reusltado = campo.adicionarVizinho(vizinho);
        assertTrue(reusltado);
    }

    @Test
    void testeVizinhoDistancia1EmBaixo() {
        Campo vizinho = new Campo(4, 3);
        boolean reusltado = campo.adicionarVizinho(vizinho);
        assertTrue(reusltado);
    }

    @Test
    void testeVizinhoDistancia2() {
        Campo vizinho = new Campo(2, 2);
        boolean reusltado = campo.adicionarVizinho(vizinho);
        assertTrue(reusltado);
    }

    @Test
    void testeNaoVizinhoDistancia2() {
        Campo vizinho = new Campo(5, 5);
        boolean reusltado = campo.adicionarVizinho(vizinho);
        assertFalse(reusltado);
    }
}