package nio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class TimeServerHandler implements Runnable {

	private Socket socket;

	public TimeServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);

			String currentTime = null;
			String body = null;
			while (true) {
				body = in.readLine();
				if (body == null) {
					break;
				}
				System.out.println("time server receive:" + body);
				currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? String.valueOf(System.currentTimeMillis()) : currentTime;
				out.println(currentTime);
			}
		} catch (IOException e) {
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
			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				this.socket = null;
			}
			e.printStackTrace();
		}
	}

}