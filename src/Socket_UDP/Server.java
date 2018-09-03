package Socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		byte[] buff = new byte[1024];
	    try {
			DatagramSocket dSocket=new DatagramSocket(8800);
			DatagramPacket p =new DatagramPacket(buff, buff.length);
			dSocket.receive(p);
			buff=p.getData();
			String content = new String(buff);
			System.out.println("服务端收到："+content);
			
			SocketAddress socketAddress = p.getSocketAddress();
			
			buff="Hi ~,client!".getBytes();
			DatagramPacket dPacket = new DatagramPacket(buff, buff.length, socketAddress);
			dSocket.send(dPacket);
			
			dSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
