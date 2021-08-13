package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 0.1
 * @author anderson
 * @description Servidor Socket
 */
public class Servidor {

    public static void main(String[] args) {
//        Criar um servidor socket -> ServerSocket
        try {
            // Instância do ServerSocket e informar a porta que ele deve
            // aguardar requisições
           ServerSocket servidor = new ServerSocket(1234);
           System.out.println("Servidor Online");
           
           while (true) {
//           Aguardar uma conexão
//           Quando a conexão é feita, retorna o cliente que se conectou
            Socket cliente =  servidor.accept();
            System.out.println("Uma nova Conexão realizada");
            System.out.println("Ip: " + cliente.getInetAddress());
            System.out.println("Porta: " + cliente.getPort());
           
//            Receber a mensagem do cliente
            Scanner entrada = new Scanner(cliente.getInputStream());
            String msg = entrada.nextLine();
            System.out.println(msg);
           }
        } catch (IOException ex) {
            System.out.println("Porta Ocupada");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
