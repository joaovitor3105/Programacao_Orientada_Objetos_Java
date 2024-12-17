package lab01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Corrida corrida = new Corrida();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite nome do motorista:");
        String nome = scanner.nextLine();
        corrida.setNomedoMotorista(nome);

        System.out.println("\nDigite a fabricante:");
        String fabricante = scanner.nextLine();
        corrida.setFabricantedoVeiculo(fabricante);

        System.out.println("\nDigite o modelo do carro:");
        String modelo = scanner.nextLine();
        corrida.setModelodoCarro(modelo);

        System.out.println("\nDigite a motorização:");
        Float motorizacao = scanner.nextFloat();
        corrida.setMotorizacaodoCarro(motorizacao);

        System.out.println("\nDigite o km inicial:");
        int kminicial = scanner.nextInt();
        corrida.setQuilometragemInicial(kminicial);

        System.out.println("\nDigite a km final:");
        int kmfinal = scanner.nextInt();
        corrida.setQuilometragemFinal(kmfinal);

        scanner.close();
        corrida.imprimir();

    }
}
