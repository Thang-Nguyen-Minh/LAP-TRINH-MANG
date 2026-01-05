package UDPPP;
import java.math.*;
import java.net.*;
public class REVIEW2 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String stc="B22DCVT525";
		String qc="seYgdOZt";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress ip=InetAddress.getByName(host);
			String sC=";"+stc+";"+qc;
			byte[] sD=sC.getBytes();
			DatagramPacket dp=new DatagramPacket(sD,sD.length,ip,port);
			socket.send(dp);
			byte[] rec=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] num=input.split(";");
			BigInteger a=new BigInteger(num[1]);
			BigInteger b=new BigInteger(num[2]);
			BigInteger tong=a.add(b);
			BigInteger hieu=a.subtract(b);
			BigInteger tich=a.multiply(b);
			BigInteger thuong=a.divide(b);
			String kq=num[0]+";"+tong+","+hieu;
			byte[] skq=kq.getBytes();
			DatagramPacket dp3=new DatagramPacket(skq,skq.length,ip,port);
			socket.send(dp3);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
