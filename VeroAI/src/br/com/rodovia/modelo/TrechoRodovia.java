package br.com.rodovia.modelo;

public class TrechoRodovia {
    public static final double LIMITE_CRITICO = 30.0;

    private String identificador;
    private double quilometroInicial;
    private double quilometroFinal;
    private double nivelVegetacao;

    public TrechoRodovia(String identificador, double kmInicial, double kmFinal, double nivelVegetacaoInicial) {
        this.identificador = identificador;
        // Usamos os setters no construtor para garantir que a validação seja aplicada na criação
        setQuilometros(kmInicial, kmFinal);
        setNivelVegetacao(nivelVegetacaoInicial);
    }

    // Método para validar e definir os quilômetros simultaneamente (evita inconsistência)
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
            throw new IllegalArgumentException("[ERRO] Taxa de crescimento negativa no trecho " + identificador);
        }
        this.nivelVegetacao += taxa;
    }

    public boolean estaCritico() {
        return this.nivelVegetacao >= LIMITE_CRITICO;
    }

    // Getters
    public String getIdentificador() { return identificador; }
    public double getQuilometroInicial() { return quilometroInicial; }
    public double getQuilometroFinal() { return quilometroFinal; }
    public double getNivelVegetacao() { return nivelVegetacao; }

    // Setter de Vegetação
    public void setNivelVegetacao(double nivelVegetacao) {
        if (nivelVegetacao < 0) {
            throw new IllegalArgumentException("[ERRO] Nível de vegetação negativo: " + nivelVegetacao + "cm.");
        }
        this.nivelVegetacao = nivelVegetacao;
    }

    @Override
    public String toString() {
        double extensao = quilometroFinal - quilometroInicial;
        String status = estaCritico() ? " [CRÍTICO]" : " [OK]";
        return String.format("%s (KM %.1f ao %.1f | Extensão: %.1fkm) | Vegetação: %.2f/%.0f cm%s", 
                identificador, quilometroInicial, quilometroFinal, extensao, nivelVegetacao, LIMITE_CRITICO, status);
    }
}