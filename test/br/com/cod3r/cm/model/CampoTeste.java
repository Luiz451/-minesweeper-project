package campo_minado.test.br.com.cod3r.cm.model;

import campo_minado.src.br.com.cod3r.cm.exception.ExplosaoException;
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

    @Test
    void testeValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAlternarMarcacaoDuasChamadas() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAbrirNaoMinadoNaoMarcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void testeAbrirNaoMinadoEMarcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoEMarcado() {
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void testeAbrirMinadoENaoMarcado() {
        campo.minar();

        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }

    @Test
    void testeAbrirComVizinhos1() {

        Campo campo11 = new Campo(1, 1);
        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertFalse(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testeAbrirComVizinhos2() {

        Campo campo11 = new Campo(1, 1);
        Campo campo12 = new Campo(1, 2);
        campo12.minar();

        Campo campo22 = new Campo(2, 2);
        campo22.adicionarVizinho(campo11);
        campo.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertFalse(campo22.isAberto() && campo11.isFechado());
    }
}