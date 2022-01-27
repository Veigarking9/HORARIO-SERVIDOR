/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud3_actividad2_xabierbarreiroalberte;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author xabier.barreiroalber
 */
public class ServidorHorario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Buffer para recibir el datagrama
        byte[] buffer = new byte[1024];
        try {
            // ASOCIO EL SOCKET AL PUERTO 5555       
            DatagramSocket socket1 = new DatagramSocket(5555);
            
            // ESPERANDO DATAGRAMA
            System.out.println("Esperando datagrama ..........");
            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
            // Recibo datagrama
            socket1.receive(recibo);
            // Obtengo el numero de bytes
           
            // Obtengo String
            String paquete = new String(recibo.getData());
            
            // VISUALIZO INFORMACION
            System.out.println("Arrancando servidor de hora.");
            System.out.println("Esperando mensaje…..");
            System.out.println("Mensaje recibido desde el puerto: "+socket1.getLocalPort());
            System.out.println("Contenido del mensaje: "+paquete);
            
            socket1.close(); // cierro el socket

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
    
    

