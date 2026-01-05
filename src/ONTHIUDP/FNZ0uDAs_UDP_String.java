package ONTHIUDP;
import java.net.*;
import java.io.*;
import java.util.*;
public class FNZ0uDAs_UDP_String {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String msv="B22DCVT525";
		String qc="FNZ0uDAs";
		try{
			DatagramSocket socket = new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			String sd=";"+msv+";"+qc;
			byte[] sD=sd.getBytes();
			DatagramPacket dp1=new DatagramPacket(sD,sD.length,sv,port);
			socket.send(dp1);
			//Receive
			byte[] rec=new byte[8192];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			//Input and Solve
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] src=input.split(";");
			String reqId=src[0];
			String s1=src[1];
			String s2=src[2];
			Set<Character> set = new HashSet<>();
			for(char x: s2.toCharArray()) set.add(x);
			String sOut="";
			for(char x:s1.toCharArray()){
				if(!set.contains(x)) sOut+=x;
			}
			String kq=reqId+";"+sOut;
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
