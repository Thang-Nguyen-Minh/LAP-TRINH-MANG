package UDP;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.net.*;
public class Data_Frame {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String stc="B22DCVT525";
		String qc="FgjgHRcm";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sc=";"+stc+";"+qc;
			byte[] sd=sc.getBytes();
			DatagramPacket dp=new DatagramPacket(sd,sd.length,sever,port);
			socket.send(dp);
			//Receive
			byte[] rec=new byte[1024];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] a=input.split(";",2);
			String req=a[0];
			String[] num=a[1].split(",");
			int x1=Integer.parseInt(num[0],2);
			int x2=Integer.parseInt(num[1],2);
			int sum=x1+x2;
			String kq=req+";"+sum;
			byte[] skq=kq.getBytes();
			DatagramPacket dp3=new DatagramPacket(skq,skq.length,sever,port);
			socket.send(dp3);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
