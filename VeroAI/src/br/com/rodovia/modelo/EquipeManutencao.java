package br.com.rodovia.modelo;

public class EquipeManutencao {
    private String nomeResponsavel;

    public EquipeManutencao(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public void realizarManutencao(TrechoRodovia trecho) {
        System.out.println("\n>>> EXECUTANDO MANUTENÇÃO: " + nomeResponsavel);
        System.out.println("Limpando vegetação em: " + trecho.getIdentificador());
        trecho.setNivelVegetacao(0);
        System.out.println("Status atualizado: " + trecho.getNivelVegetacao() + "cm.");
    }
}