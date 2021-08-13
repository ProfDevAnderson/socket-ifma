
package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ClienteSocket extends javax.swing.JFrame {

    Socket cliente;
    public ClienteSocket() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBConectar = new javax.swing.JButton();
        jTMsg = new javax.swing.JTextField();
        jBEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBConectar.setText("Conectar");
        jBConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBConectarMouseClicked(evt);
            }
        });

        jBEnviar.setText("Enviar");
        jBEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEnviarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jBConectar)
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBEnviar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jTMsg))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBConectarMouseClicked
        try {
            //         Conexao com o Servidor
            cliente = new Socket("127.0.0.1", 1234);
            System.out.println("Servidor Oline");
            JOptionPane.showMessageDialog(null, "Servidor Conectado");
        } catch (IOException ex) {
            System.out.println("Conexão Recusada");
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBConectarMouseClicked

    private void jBEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEnviarMouseClicked
        String msg = jTMsg.getText();
        try {
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            saida.println(msg);
            jTMsg.setText("");
        } catch (IOException ex) {
            Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBEnviarMouseClicked

 
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteSocket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConectar;
    private javax.swing.JButton jBEnviar;
    private javax.swing.JTextField jTMsg;
    // End of variables declaration//GEN-END:variables
}
