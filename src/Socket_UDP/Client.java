package Socket_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {

	public static void main(String[] args) {
		String content = "hello server";
		byte[] buff = content.getBytes();
		DatagramSocket dSocket=null;
		try {
			dSocket = new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket dPacket = new DatagramPacket(buff, buff.length, address, 8800);
			dSocket.send(dPacket);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buff = new byte[1024];
		DatagramPacket dPacket = new DatagramPacket(buff, buff.length);
		try {
			dSocket.receive(dPacket);
			String reply = new String(dPacket.getData());
			System.out.println("客户端收到："+reply);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dSocket.close();
	}

}
