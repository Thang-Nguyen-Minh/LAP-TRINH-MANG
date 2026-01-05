package CODE14BAILIENTUC;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class FNZ0uDAs_String {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String msv="b22dcvt525";
		String qc="FNZ0uDAs";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			String sd=";"+msv+";"+qc;
			byte[] sc=sd.getBytes();
			DatagramPacket dp1=new DatagramPacket(sc,sc.length,sv,port);
			socket.send(dp1);
			byte[] rec=new byte[8192];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] so=input.split(";");
			String reqId=so[0];
			Set<Character> set=new HashSet<>();
			String s1=so[1],s2=so[2];
			for(char x:s2.toCharArray()) set.add(x);
			String s = "";
			for(char x:s1.toCharArray()){
				if(!set.contains(x)) s+=x;
			}
			String kq=reqId+";"+s;
			byte[] sendBack=kq.getBytes();
			DatagramPacket dp3=new DatagramPacket(sendBack,sendBack.length,sv,port);
			socket.send(dp3);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
