import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nomeJogador = scanner.nextLine();

        ParImpar jogo = new ParImpar(nomeJogador);
        jogo.jogar();
    }
}
