/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud3_actividad2_xabierbarreiroalberte;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/**
 *
 * @author xabier.barreiroalber
 */
public class ClienteHorario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            InetAddress destino = InetAddress.getLocalHost();
            int port = 5555; // Puerto al que envÃ­o el datagrama
            byte[] mensaje = new byte[1024];
            
            
            
            Date fecha = new Date(System.currentTimeMillis());
            String fechaCad = fecha.toString();
            mensaje = fechaCad.getBytes();
            
            // CONSTRUYO EL DATAGRAMA A ENVIAR
            DatagramPacket envio = new DatagramPacket (mensaje, mensaje.length,
                                        destino, port);
            DatagramSocket socket = new DatagramSocket(34567); //Puerto local
            System.out.println("Enviando petición al servidor….");
            System.out.println("Mensaje enviado: hora");
            System.out.println("Recibiendo respuesta.....");
            System.out.println("Mensaje recibido: "+fechaCad);
                   
            
            // ENVIO DATAGRAMA
            socket.send(envio);
            socket.close(); // cierro el socket
            
                    
            
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}

    
