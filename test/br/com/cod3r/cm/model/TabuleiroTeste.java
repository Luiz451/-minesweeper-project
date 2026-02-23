package campo_minado.test.br.com.cod3r.cm.model;

import campo_minado.src.br.com.cod3r.cm.model.Campo;
import campo_minado.src.br.com.cod3r.cm.model.Tabuleiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabuleiroTeste {

    @Test
    void testeObjetivoAlcancadoTodosTrue() {
        Tabuleiro tabuleiro = new Tabuleiro(2, 2, 0);

        tabuleiro.abrir(1, 1);
        tabuleiro.abrir(1, 2);
        tabuleiro.abrir(2, 1);
        tabuleiro.abrir(2, 2);

        assertTrue(tabuleiro.objetivoAlcancado(), "O tabuleiro novo deve constar como resolvido");
    }

    @Test
    void testeObjetivoAlcancadoFalse() {
        Tabuleiro tabuleiro = new Tabuleiro(2, 2, 0);

        assertFalse(tabuleiro.objetivoAlcancado(), "O tabuleiro novo não deve constar como resolvido");
    }
}