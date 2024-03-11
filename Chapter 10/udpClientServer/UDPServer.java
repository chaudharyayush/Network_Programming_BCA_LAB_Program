package udpClientServer;


import java.net.*;

public class UDPServer {
   public static void main(String args[]) throws Exception {
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];


      DatagramSocket serverSocket = new DatagramSocket(9876);
      
      while(true) {
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         
         String sentence = new String(receivePacket.getData());
         System.out.println("Client says: "+ sentence);

         // send response to the client
         InetAddress IPAddress = receivePacket.getAddress();
         int port = receivePacket.getPort();
         sendData = sentence.getBytes();
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
         serverSocket.send(sendPacket);
      }
   }
}