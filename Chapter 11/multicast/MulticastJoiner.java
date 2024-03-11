package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastJoiner {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			// Define the multicast group address and port
			InetAddress multicastAddress = InetAddress.getByName("224.0.0.1");
			int multicastPort = 8888;

			// Create a multicast socket and join the group
			MulticastSocket socket = new MulticastSocket(multicastPort);
			socket.joinGroup(multicastAddress);

			System.out.println("Joined multicast group: " + multicastAddress.getHostAddress());

			// Create a buffer to store received data
			byte[] buffer = new byte[1024];

			// Continuously receive and process incoming multicast packets
			while (true) {
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);

				// Extract the received data from the packet
				byte[] receivedData = packet.getData();
				int receivedLength = packet.getLength();
				String message = new String(receivedData, 0, receivedLength);

				System.out.println("Received message: " + message);

				// Add your logic to process the received message here

				// Check if you want to exit the loop and leave the multicast group
				// For example, if a certain condition is meet
				if (message.equals("exit")) {
					break;
				}
			}

			// Leave the multicast group and close the socket
			socket.leaveGroup(multicastAddress);
			socket.close();

			System.out.println("Left multicast group");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}