package campo_minado.src.br.com.cod3r.cm.model;

import campo_minado.src.br.com.cod3r.cm.exception.ExplosaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private int minas;
    private boolean primeiroMovimento = true;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarVizinhos();
    }

    public void abrir(int linha, int coluna) {
        int linhaInterna = linha - 1;
        int colunaInterna = coluna - 1;

        if(primeiroMovimento) {
            sortearMinas(linhaInterna, colunaInterna);
            primeiroMovimento = false;
        }

        try {
            campos.stream()
                    .filter(c -> c.getLinha() == linhaInterna && c.getColuna() == colunaInterna)
                    .findFirst()
                    .ifPresent(c -> c.abrir());
        } catch (ExplosaoException e) {
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }

    public void alternarMarcacao(int linha, int coluna) {
        int linhaInterna = linha - 1;
        int colunaInterna = coluna - 1;

        campos.stream()
                .filter(c -> c.getLinha() == linhaInterna && c.getColuna() == colunaInterna)
                .findFirst()
                .ifPresent(c -> c.alternarMarcacao());
    }

    public boolean objetivoAlcancado() {
        return campos.stream()
                .allMatch(c -> c.objetivoAlcancado());
    }

    public void reiniciarTabuleiro() {
        campos.stream()
                .forEach(c -> c.reiniciar());
    }

    public void adicionarCampo(Campo campo) {
        campos.add(campo);
    }

    private void gerarCampos() {
        for (int l = 0; l < linhas; l++) {
            for (int c = 0; c < colunas; c++) {
                campos.add(new Campo(l, c));
            }
        }
    }

    private void associarVizinhos() {
        for (Campo c1: campos) {
            for (Campo c2: campos) {
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas(int linhaSegura, int colunaSegura) {
        int minasArmadas = 0;

        while(minasArmadas < minas) {
            int aleatorio = (int) (Math.random() * campos.size());
            Campo campoSorteado = campos.get(aleatorio);

            if(campoSorteado.getLinha() != linhaSegura || campoSorteado.getColuna() != colunaSegura) {

                if(campoSorteado.minar()) {
                    minasArmadas++;
                }
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("   ");
        for (int c = 0; c < colunas; c++) {
            s.append(" ");
            s.append(c + 1);
            s.append(" ");
        }
        s.append("\n");

        int i = 0;
        for (int l = 0; l < linhas; l++) {
            s.append(" ");
            s.append(l + 1);
            s.append(" ");

            for (int c = 0; c < colunas; c++) {
                s.append(" ");
                s.append(campos.get(i));
                s.append(" ");
                i++;
            }
            s.append("\n");
        }
        return s.toString();
    }
}
