package ONTHIUDP;
import java.io.*;
import java.util.*;
import java.net.*;

public class String_FNZ0uDAs {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String msv="B22DCVT525";
		String qc="FNZ0uDAs";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			String sd=";"+msv+";"+qc;
			byte[] sdd=sd.getBytes();
			DatagramPacket dp1=new DatagramPacket(sdd,sdd.length,sv,port);
			socket.send(dp1);
			byte[] rec=new byte[8192];
			DatagramPacket dp2 = new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] a=input.split(";");
			String s1=a[1],s2=a[2];
			Set<Character> set = new HashSet<>();
			//vứt s2 vào set, duyệt qua s1, không có trong s2 thì đưa vào kết qủa
			for(char c:s2.toCharArray()) set.add(c);
			String sOut="";
			for(char x:s1.toCharArray()){
				if(!set.contains(x)) sOut+=x;
			}
			String kq=a[0]+";"+sOut;
			byte[] sendBack=kq.getBytes();
			DatagramPacket dp3 = new DatagramPacket(sendBack,sendBack.length,sv,port);
			socket.send(dp3);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
