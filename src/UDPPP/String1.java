package UDPPP;
import java.net.*;
public class String1 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String studentCode="B22DCVT525";
		String qCode="Q7bdEbPf";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			byte[] rec=new byte[4096];
			DatagramPacket recPac=new DatagramPacket(rec,rec.length);
			socket.receive(recPac);
			String input=new String(recPac.getData(),0,recPac.getLength());
			String[] p=input.split(";",2);
			String rq=p[0];
			String[] x=p[1].split("\\s+");
			String kq="";
			for(String w:x){
				if(!w.isEmpty()) kq+=w.substring(0,1).toUpperCase()+w.substring(1).toLowerCase()+" ";
			}
			String kq2=rq+";"+kq.trim();
			byte[] sendKq=kq2.getBytes();
			DatagramPacket dp2=new DatagramPacket(sendKq,sendKq.length,sever,port);
			socket.send(dp2);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
