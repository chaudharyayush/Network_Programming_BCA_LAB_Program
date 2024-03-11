package udpClientServer;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
	public static void main(String args[]) throws Exception {
		// allocating the buffer sizes
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];

		// read message to send to the server
		System.out.println("Say Something: ");
		Scanner sc = new Scanner(System.in);
		String inFromUser = sc.nextLine();

		// start client socket
		DatagramSocket clientSocket = new DatagramSocket(0);
		InetAddress IPAddress = InetAddress.getByName("localhost");

		// send read messge to server
		sendData = inFromUser.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacket);

		// reveive response from the server
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);

		// closing the socket, at the end
		clientSocket.close();
	}
}