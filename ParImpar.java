import java.util.Random;
import java.util.Scanner;

public class ParImpar {
    private String nomeJogador;
    private String escolhaJogador;
    private int numeroJogador;
    private int numeroComputador;

    public ParImpar(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao jogo Par ou Ímpar!");

        System.out.print("Escolha Par (P) ou Ímpar (I): ");
        escolhaJogador = scanner.nextLine().toUpperCase();

        while (!escolhaJogador.equals("P") && !escolhaJogador.equals("I")) {
            System.out.println("Escolha inválida. Por favor, escolha Par (P) ou Ímpar (I).");
            System.out.print("Escolha Par (P) ou Ímpar (I): ");
            escolhaJogador = scanner.nextLine().toUpperCase();
        }

        System.out.print("Digite um número inteiro entre 0 e 5: ");
        numeroJogador = scanner.nextInt();

        while (numeroJogador < 0 || numeroJogador > 5) {
            System.out.println("Número inválido. Por favor, digite um número entre 0 e 5.");
            System.out.print("Digite um número inteiro entre 0 e 5: ");
            numeroJogador = scanner.nextInt();
        }

        numeroComputador = random.nextInt(6); // Gera um número aleatório entre 0 e 5
        System.out.println("O computador escolheu o número " + numeroComputador + ".");

        int soma = numeroJogador + numeroComputador;
        System.out.println(nomeJogador + " escolheu o número " + numeroJogador + ".");
        System.out.println("A soma dos números é " + soma + ".");

        boolean resultadoPar = soma % 2 == 0;

        if ((resultadoPar && escolhaJogador.equals("P")) || (!resultadoPar && escolhaJogador.equals("I"))) {
            System.out.println(nomeJogador + " venceu! A soma é " + soma + ".");
        } else {
            System.out.println("O computador venceu! A soma é " + soma + ".");
        }

        scanner.close();
    }
}