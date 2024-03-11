package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
	public static void main(String[] args) {
		try {
			// Define the multicast group address and port
			InetAddress multicastAddress = InetAddress.getByName("224.0.0.1");
			int multicastPort = 8888;

			// Create a multicast socket
			MulticastSocket socket = new MulticastSocket();

			// Create the message to be sent
			String message = "Hello, multicast!";
			byte[] data = message.getBytes();

			// Create a datagram packet with the message and destination address/port
			DatagramPacket packet = new DatagramPacket(data, data.length, multicastAddress, multicastPort);

			// Send the packet
			socket.send(packet);

			// Close the socket
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}