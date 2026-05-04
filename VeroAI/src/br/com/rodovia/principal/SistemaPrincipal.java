package br.com.rodovia.principal;

import br.com.rodovia.modelo.EquipeManutencao;
import br.com.rodovia.modelo.TrechoRodovia;

public class SistemaPrincipal {
    public static void main(String[] args) {
        try {
            TrechoRodovia trecho1 = new TrechoRodovia("Rodovia Anhanguera", 50.0, 60.0, 25.0);
            TrechoRodovia trecho2 = new TrechoRodovia("Rodovia dos Bandeirantes", 20.0, 35.0, 10.0);
            //TrechoRodovia trecho3 = new TrechoRodovia("Rodovia Presidente Dutra", -5.0, 10.0, -67.0); ------> Teste de quilometroInicial negativo e alturaInicial negativa.

            System.out.println("--- MONITORAMENTO INICIAL ---");
            System.out.println(trecho1);
            System.out.println(trecho2);

            System.out.println("\n--- APÓS PERÍODO DE CHUVAS (Simulação de Crescimento) ---");
            
            trecho1.registrarCrescimento(8.5); 
            trecho2.registrarCrescimento(5.0); 
            //trecho3.registrarCrescimento(-67.0); ------> Teste de crescimento negativo.

            System.out.println(trecho1);
            System.out.println(trecho2);

            System.out.println("\n--- ANÁLISE DE PRIORIDADE E MANUTENÇÃO ---");
            EquipeManutencao equipeSetorNorte = new EquipeManutencao("Equipe Verde-Sul");

            if (trecho1.estaCritico()) {
                System.out.println("ALERTA: " + trecho1.getIdentificador() + " atingiu nível crítico!");
                equipeSetorNorte.realizarManutencao(trecho1);
            } 
            
            if (trecho2.estaCritico()) {
                System.out.println("ALERTA: " + trecho2.getIdentificador() + " atingiu nível crítico!");
                equipeSetorNorte.realizarManutencao(trecho2);
            } else if (!trecho1.estaCritico()) {
                System.out.println("Nenhum trecho atingiu o limite crítico hoje.");
            }

            System.out.println("\n--- RELATÓRIO FINAL DE STATUS ---");
            System.out.println(trecho1);
            System.out.println(trecho2);

        } catch (IllegalArgumentException e) {
            System.err.println("\n[FALHA NO SISTEMA]: " + e.getMessage());
        }
    }
}