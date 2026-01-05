package REVIEWUDP;
import java.io.*;
import java.util.*;
import java.net.*;
public class String_Q7bdEbPf {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String stC="B22DCVT525";
		String qC="Q7bdEbPf";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sC=";"+stC+";"+qC;
			byte[] sD=sC.getBytes();
			DatagramPacket dp=new DatagramPacket(sD,sD.length,sever,port);
			socket.send(dp);
			//receive
			byte[] rec=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			//input
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] word=input.split(";");
			String[] ww=word[1].split("\\s+");
			String kq="";
			for(String x:ww){
				if(!x.isEmpty()) kq+=x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase()+" ";
			}
			//sendKq
			String kq2=word[0]+";"+kq;
			byte[] skq=kq2.getBytes();
			DatagramPacket dp3=new DatagramPacket(skq,skq.length,sever,port);
			socket.send(dp3);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
