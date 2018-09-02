package Socket_multiLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {
	private Socket socket =null;
	public SocketThread() {
		
	}
	public SocketThread(Socket socket) {
		this.socket=socket;
		
	}
	
	@Override
	public void run() {
		InputStream inputStream;
		try {
			inputStream = socket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String content = null;
			while((content=bufferedReader.readLine())!=null) {
				System.out.println("服务端："+content);
			}
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.write("OK");
			printWriter.flush();
			
			printWriter.close();
			outputStream.close();
			bufferedReader.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
