package udpClientServer;


import java.net.*;

public class UDPServer {
   public static void main(String args[]) throws Exception {
	   //receiveData and sendData are byte arrays used to store data received from and sent to the client
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];


     // Creates a DatagramSocket instance bound to port 9876. This socket will be used to send and receive UDP packets
      DatagramSocket serverSocket = new DatagramSocket(9876);
      
      //Starts an infinite loop to keep the server running indefinitely, waiting for and processing client messages
      while(true) {
    	  
    	 //Creates a DatagramPacket to hold incoming data. The receivePacket is initialized with the receiveData array and its length
         DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
         
         //The serverSocket.receive(receivePacket) method waits for a packet to arrive from a client. When a packet is received, its data is stored in receivePacket
         serverSocket.receive(receivePacket);
         
         //Converts the received byte data into a string using new String(receivePacket.getData()) and stores it in the sentence variable
         String sentence = new String(receivePacket.getData());
         System.out.println("Client says: "+ sentence);

         // send response to the client
         
         //Retrieves the IP address of the client that sent the packet using receivePacket.getAddress()
         InetAddress IPAddress = receivePacket.getAddress();
         
         //Retrieves the port number of the client that sent the packet using receivePacket.getPort()
         int port = receivePacket.getPort();
         
         //Converts the response message (sentence) back into a byte array using sentence.getBytes() and stores it in sendData
         sendData = sentence.getBytes();
         
         //Creates a DatagramPacket for the response, initialized with sendData, its length, the client's IP address (IPAddress), and the client's port number (port)
         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
         
         //Sends the response packet back to the client using serverSocket.send(sendPacket)
         serverSocket.send(sendPacket);
      }
   }
}