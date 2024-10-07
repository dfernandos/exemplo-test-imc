package com.mapeando;

import java.util.Scanner;

public class CalculoIMC {

    // Método para calcular o IMC e retornar a classificação
    public static String calcularIMC(double peso, double altura) {
        // Validação de altura: deve ser maior que zero
        if (altura <= 0) {
            throw new IllegalArgumentException("A altura deve ser maior que zero.");
        }

        // Fórmula do IMC
        double imc = peso / (altura * altura);
        return classificarIMC(imc);
    }

    // Método auxiliar para classificar o IMC
    private static String classificarIMC(double imc) {
        if (imc < 16) {
            return "Magreza grave";
        } else if (imc >= 16 && imc < 16.9) {
            return "Magreza moderada";
        } else if (imc >= 17 && imc < 18.4) {
            return "Magreza leve";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso saudável";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidade grau I";
        } else if (imc >= 35 && imc < 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }

    // Método principal para interação com o usuário
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso (em kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Digite sua altura (em metros): ");
        double altura = scanner.nextDouble();

        try {
            String classificacao = calcularIMC(peso, altura);
            System.out.println("A classificação do IMC é: " + classificacao);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close(); // Fecha o scanner para evitar vazamentos de recursos
        }
    }
}

