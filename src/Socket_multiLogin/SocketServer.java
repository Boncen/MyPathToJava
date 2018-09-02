package Socket_multiLogin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	private static int num;
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(8800);
			while (true) {
				
				Socket socket = serverSocket.accept();
				num++;
				SocketThread thread = new SocketThread(socket);
				thread.start();
				System.out.println("当前登录人数："+num);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
