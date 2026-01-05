package UDP;
import java.net.*;
import java.math.*;
public class DataType_sLDnSH6S {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String stc="B22DCVT525";
		String qC="sLDnSH6S";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sc=";"+stc+";"+qC;
			byte[] sendData=sc.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			//receive
			byte[] rec=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] num=input.split(";");
			BigInteger a=new BigInteger(num[1]);
			String s=String.valueOf(a);
			int sum=0;
			for(int i=0;i<s.length();i++){
				sum+=Integer.parseInt(String.valueOf(s.charAt(i)));
			}
			String kq=num[0]+";"+String.valueOf(sum);
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
