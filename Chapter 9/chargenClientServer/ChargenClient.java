package chargenClientServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class ChargenClient {
    public static void main(String[] args) throws IOException {
        // Connect to the server
        SocketChannel socket = SocketChannel.open();
        socket.connect(new InetSocketAddress("localhost", 8888));

        // Read data from the server
        ByteBuffer buffer = ByteBuffer.allocate(74);
        while (socket.read(buffer) != -1) {
            buffer.flip();
            String data = StandardCharsets.US_ASCII.decode(buffer).toString();
            System.out.print(data);
            buffer.clear();
        }

        // Close the connection
        // socket.close();
    }
}

