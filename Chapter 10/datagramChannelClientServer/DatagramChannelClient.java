package datagramChannelClientServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChannelClient {
	public static void main(String[] args) throws IOException {
		DatagramChannel client = null;
		client = DatagramChannel.open();
		client.bind(null);
		String msg = "Hello World!";
		ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
		InetSocketAddress serverAddress = new InetSocketAddress("localhost", 8989);
		client.send(buffer, serverAddress);
		buffer.clear();
		client.receive(buffer);
		buffer.flip();
		client.close();
	}
}