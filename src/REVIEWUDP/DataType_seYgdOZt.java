package REVIEWUDP;
import java.io.*;
import java.util.*;
import java.net.*;
import java.math.*;
public class DataType_seYgdOZt {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String st="B22DCVT525";
		String qC="seYgdOZt";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sendCode=";"+st+";"+qC;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			//Receive
			byte[] data=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(data,data.length);
			socket.receive(dp2);
			//input
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] num=input.split(";");
			String rq=num[0];
			//Số nguyên lớn thì vứt thẳng string vào là oke
			//tong : add, tru : subtract, nhan : multiply, chia : divide
			BigInteger a=new BigInteger(num[1]);
			BigInteger b=new BigInteger(num[2]);
			BigInteger tong=a.add(b);
			BigInteger hieu=a.subtract(b);
			BigInteger tich=a.multiply(b);
			BigInteger thuong=a.divide(b);
			//sendKQ
			String kq=rq+";"+tong+","+hieu;
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
