package campo_minado.src.br.com.cod3r.cm;

import campo_minado.src.br.com.cod3r.cm.model.Tabuleiro;
import campo_minado.src.br.com.cod3r.cm.vision.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(10, 10, 6);
        new TabuleiroConsole(tabuleiro);
    }
}