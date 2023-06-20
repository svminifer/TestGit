package nio;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TimeServer {

	public static void main(String[] args) throws IOException {

		int port = 8088;

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8088);
			System.out.println("Server Start：" + port);
			Socket socket = null;
			while (true) {
				socket = serverSocket.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} finally {
			if (serverSocket != null) {
				System.out.println("Server close");
				serverSocket.close();
				serverSocket = null;
			}
		}
	}


}



