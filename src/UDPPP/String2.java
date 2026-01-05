package UDPPP;
import java.util.*;
import java.net.*;
public class String2 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String studentCode="B22DCVT525";
		String qCode="pZmkXBlb";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			byte[] rec=new byte[4096];
			DatagramPacket recPac=new DatagramPacket(rec,rec.length);
			socket.receive(recPac);
			String input=new String(recPac.getData(),0,recPac.getLength());
			System.out.println(input);
			String[] p=input.split(";",2);
			String rq=p[0];
			String[] word=p[1].split("\\s+");
			System.out.println(word);
			Arrays.sort(word, String.CASE_INSENSITIVE_ORDER.reversed());
			String kq=rq+";"+String.join(",",word);
			byte[] sendKq=kq.getBytes();
			DatagramPacket dp2=new DatagramPacket(sendKq,sendKq.length,sever,port);
			socket.send(dp2);
			System.out.println(kq);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
