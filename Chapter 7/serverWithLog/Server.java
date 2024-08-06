package serverWithLog;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Server {
	public static Logger infoLog = Logger.getLogger("requests");
	public static Logger errorLog = Logger.getLogger("errors");

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9000);
			//ss.setSoTimeout(1);
		} catch (IOException e) {
			errorLog.log(Level.SEVERE, "could not start the server");
		}

		infoLog.info("Waiting for connections....");
		/*
		 * Alternatively, it can also be written errorLog.log(Level.INFO,
		 * "Waiting for connections....")
		 */

		try {
			Socket cs;
			cs = ss.accept();
			infoLog.info("CONNECTED");

			// read the message
			InputStreamReader in = new InputStreamReader(cs.getInputStream());
			BufferedReader input = new BufferedReader(in);
			String message = input.readLine();
			infoLog.info("client says: " + message);
			// send response
			PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
			out.println("you said, " + "'" + message + "'");

			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			errorLog.log(Level.SEVERE, "Cannot establish the connection", e);

		} catch (Exception e) {
			errorLog.log(Level.SEVERE, "Something went wrong " + e.getMessage(), e);
		}
	}
}