package UDPPP;
import java.math.*;
import java.net.*;

public class DataType3 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="seYgdOZt";
		try{
			//Create Socket
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			//Send ;studentCode;qCode
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			//Receive input
			byte[] rec=new byte[4096];
			DatagramPacket recPac=new DatagramPacket(rec,rec.length);
			socket.receive(recPac);
			String input=new String(recPac.getData(),0,recPac.getLength());
			//Solve
			String[] num=input.split(";");
			for(String x:num) System.out.println(x);
			String rq=num[0];
			BigInteger a=new BigInteger(num[1]);
			BigInteger b=new BigInteger(num[2]);
			BigInteger tong=a.add(b);
			BigInteger hieu=a.subtract(b);
			BigInteger tich=a.multiply(b);
			BigInteger thuong=a.divide(b);
			System.out.println(tong);
			System.out.println(hieu);
			//Send kq
			String kq=rq+";"+tong+","+hieu;
			byte[] sendKQ=kq.getBytes();
			DatagramPacket sendKq=new DatagramPacket(sendKQ,sendKQ.length,sever,port);
			socket.send(sendKq);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
