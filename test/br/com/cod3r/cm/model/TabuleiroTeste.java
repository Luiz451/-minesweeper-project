package campo_minado.test.br.com.cod3r.cm.model;

import campo_minado.src.br.com.cod3r.cm.model.Tabuleiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabuleiroTeste {

    private Tabuleiro tabuleiro;

    @BeforeEach
    void iniciarTabuleiro() {
        tabuleiro = new Tabuleiro(5, 5, 7);
    }
}