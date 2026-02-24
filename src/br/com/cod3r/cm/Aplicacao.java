package campo_minado.src.br.com.cod3r.cm;

import campo_minado.src.br.com.cod3r.cm.model.Tabuleiro;

public class Aplicacao {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(10, 10, 6);

        tabuleiro.alternarMarcacao(4, 4);
        tabuleiro.alternarMarcacao(4, 5);
        tabuleiro.abrir(3, 3);

        System.out.println(tabuleiro);
    }
}