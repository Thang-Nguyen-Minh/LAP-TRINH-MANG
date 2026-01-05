package REVIEWUDP;
import java.io.*;
import java.util.*;
import java.net.*;
public class String_pZmkXBlb {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String st="B22DCVT525";
		String qC="pZmkXBlb";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sendCode=";"+st+";"+qC;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			//receive
			byte[] data=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(data,data.length);
			socket.receive(dp2);
			//input
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] x=input.split(";");
			List<String> list=new ArrayList<>();
			String rq=x[0];
			String[] word=x[1].split("\\s+");
			for(String w:word) list.add(w);
			Collections.sort(list,String.CASE_INSENSITIVE_ORDER.reversed());
			String kq=String.join(",",list);
			String kq2=rq+";"+kq;
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
