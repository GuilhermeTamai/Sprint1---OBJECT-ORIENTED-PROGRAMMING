package br.com.rodovia.modelo;

public class TrechoRodovia {

    public static final double LIMITE_CRITICO = 30.0;

    private String identificador;
    private double quilometroInicial;
    private double quilometroFinal;
    private double nivelVegetacao;

    public TrechoRodovia(String identificador, double kmInicial, double kmFinal, double nivelVegetacaoInicial) {
        this.identificador = identificador;
        setQuilometros(kmInicial, kmFinal);
        this.nivelVegetacao = Math.max(0, nivelVegetacaoInicial);
    }

    public void setQuilometros(double inicial, double fim) {
        if (inicial < 0 || fim < 0) {
            throw new IllegalArgumentException("[ERRO] Quilometragem não pode ser negativa (Informado: " + inicial + " a " + fim + ")");
        }
        if (fim <= inicial) {
            throw new IllegalArgumentException("[ERRO] O KM final deve ser maior que o inicial (Informado: " + inicial + " a " + fim + ")");
        }
        this.quilometroInicial = inicial;
        this.quilometroFinal = fim;
    }

    public void registrarCrescimento(double taxa) {
        if (taxa < 0) {
            throw new IllegalArgumentException("[ERRO] Taxa de crescimento inválida no trecho " + identificador);
        }
        this.nivelVegetacao += taxa;
    }

    public boolean estaCritico() {
        return this.nivelVegetacao >= LIMITE_CRITICO;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getQuilometroInicial() {
        return quilometroInicial;
    }

    public double getQuilometroFinal() {
        return quilometroFinal;
    }

    public double getNivelVegetacao() {
        return nivelVegetacao;
    }

    public void setNivelVegetacao(double nivelVegetacao) {
        this.nivelVegetacao = Math.max(0, nivelVegetacao);
    }

    @Override
    public String toString() {
        double extensao = quilometroFinal - quilometroInicial;
        String status = estaCritico() ? " [CRÍTICO]" : " [OK]";

        return String.format(
            "%s (KM %.1f ao %.1f | Extensão: %.1fkm) | Vegetação: %.2f/%.0f cm%s",
            identificador,
            quilometroInicial,
            quilometroFinal,
            extensao,
            nivelVegetacao,
            LIMITE_CRITICO,
            status
        );
    }
}
