package REVIEWUDP;
import java.util.*;
import java.net.*;
public class DataType_3A0ERGkc {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="3A0ERGkc";
		try{
			//Create Socket
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			//Send Student
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			//Receive
			byte[] data=new byte[4096];
			DatagramPacket rec=new DatagramPacket(data,data.length);
			socket.receive(rec);
			//input
			String input=new String(rec.getData(),0,rec.getLength());
			String[] word=input.split(";",2);
			String rq=word[0];
			String[] num=word[1].split(",");
			List<Integer> list=new ArrayList<>();
			for(String x:num) list.add(Integer.parseInt(x));
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			for(int x:list){
				if(x<min) min=x;
				if(x>max) max=x;
			}
			//sendKQ
			String kq=rq+";"+max+","+min;
			byte[] sendKQ=kq.getBytes();
			DatagramPacket sendPac=new DatagramPacket(sendKQ,sendKQ.length,sever,port);
			socket.send(sendPac);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
