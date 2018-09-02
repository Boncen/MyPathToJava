package Socket2_obj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8800);
			OutputStream outputStream = socket.getOutputStream();
			
			User user = new User("boncen","1234567890");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(user);
			objectOutputStream.flush();
			socket.shutdownOutput();//结束客户端的输出信息
			
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String content=null;
			
				while ((content=bufferedReader.readLine()) != null) {

					System.out.println(content+"连接服务器成功，正在跳转。。。");
				} 
			
			bufferedReader.close();
			inputStream.close();
			objectOutputStream.close();
			outputStream.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
