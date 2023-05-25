import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String mensagem = leitor.readLine();
                System.out.println(mensagem);

                if (mensagem.startsWith("Sua vez")) {
                    int escolha = Integer.parseInt(teclado.readLine());
                    escritor.println(escolha);
                } else if (mensagem.startsWith("Fim do jogo")) {
                    String resposta = teclado.readLine().toUpperCase();
                    escritor.println(resposta);
                    if (!resposta.equals("S")) {
                        break;
                    }
                }
            }

            // Encerra a conexão
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
