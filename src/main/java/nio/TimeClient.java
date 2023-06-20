package nio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class TimeClient {

	public static void main(String[] args) {
		int port = 8088;

		Socket socket = null;
		BufferedReader in =null;
		PrintWriter out = null;
		try {
		socket = new Socket("127.0.0.1", port);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);

		out.println("QUERY TIME ORDER");
		System.out.println("client send");
		String resp = in.readLine();
		System.out.println("client receive："+resp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				socket = null;
			}
		}
	}
}
