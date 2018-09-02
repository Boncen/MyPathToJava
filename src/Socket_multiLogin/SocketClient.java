package Socket_multiLogin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8800);
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			String content="user:bossncen;passwd:123123";
			printWriter.write(content);
			printWriter.flush();
			socket.shutdownOutput();//结束客户端的输出信息
			
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			if (bufferedReader.readLine().contains("OK")) {
				System.out.println("连接服务器成功，正在跳转。。。");
			}
			
			bufferedReader.close();
			inputStream.close();
			printWriter.close();
			outputStream.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
