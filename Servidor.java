import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Aguardando conexões dos jogadores...");

            // Aceita a conexão do primeiro jogador
            Socket jogador1 = serverSocket.accept();
            System.out.println("Jogador 1 conectado.");

            // Aguarda a conexão do segundo jogador
            Socket jogador2 = serverSocket.accept();
            System.out.println("Jogador 2 conectado.");

            // Cria os leitores e escritores para comunicação com os jogadores
            BufferedReader leitor1 = new BufferedReader(new InputStreamReader(jogador1.getInputStream()));
            PrintWriter escritor1 = new PrintWriter(jogador1.getOutputStream(), true);

            BufferedReader leitor2 = new BufferedReader(new InputStreamReader(jogador2.getInputStream()));
            PrintWriter escritor2 = new PrintWriter(jogador2.getOutputStream(), true);

            // Inicia o jogo
            while (true) {
                escritor1.println("Sua vez de escolher um número (0 a 5):");
                int escolha1 = Integer.parseInt(leitor1.readLine());

                escritor2.println("Sua vez de escolher um número (0 a 5):");
                int escolha2 = Integer.parseInt(leitor2.readLine());

                int soma = escolha1 + escolha2;
                escritor1.println("A soma é: " + soma);
                escritor2.println("A soma é: " + soma);

                boolean par = soma % 2 == 0;

                if(par == true){
                    escritor1.println("Você venceu! A soma é par.");
                    escritor2.println("Você perdeu! A soma é par.");
                } else{
                    escritor1.println("Você perdeu! A soma é ímpar.");
                    escritor2.println("Você venceu! A soma é ímpar.");
                }


                escritor1.println("Fim do jogo. Deseja jogar novamente? (S/N)");
                escritor2.println("Fim do jogo. Deseja jogar novamente? (S/N)");

                String resposta1 = leitor1.readLine().toUpperCase();
                String resposta2 = leitor2.readLine().toUpperCase();

                if (!resposta1.equals("S") || !resposta2.equals("S")) {
                    break;
                }
            }

            // Encerra as conexões
            jogador1.close();
            jogador2.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
