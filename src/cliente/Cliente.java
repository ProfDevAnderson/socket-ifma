package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anderson
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            //     Criar uma instancia de socket
            Socket cliente = new Socket("127.0.0.1", 1234);
            System.out.println("Conexão Realizada com sucesso");

//            Como enviar mensagens? Utilizar o OutpStream
//              Instanciar um PrintStream            
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            saida.println("Oi servidor");
            System.out.println("Msg enviada");

        } catch (IOException ex) {
            System.out.println("Conexão falhou");
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
