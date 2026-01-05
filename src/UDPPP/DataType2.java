package UDPPP;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataType2 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="QVWkR86P";
		try{
			//Create DatagramSocket and InetAddress
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			//Send ;studentCode;qCode(send Packet) + create DatagramPacket
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			//Receive input
			byte[] rec=new byte[4096];
			DatagramPacket recPacket=new DatagramPacket(rec,rec.length);
			socket.receive(recPacket);
			//Input = new String(packet.getData(),0,packet.getLength())
			String input=new String(recPacket.getData(),0,recPacket.getLength());
			//Solve
			String[] p=input.split(";",2);
			String rq=p[0];
			String[] num=p[1].split(",");
			List<Integer> list=new ArrayList<>();
			for(String x:num) list.add(Integer.parseInt(x));
			int secondMax=0,secondMin=0;
			Collections.sort(list);
			int n=list.size();
			for(int i=n-1;i>=1;i--){
				if (list.get(i)!=list.get(i-1)) {
					secondMax=list.get(i-1);
					break;
				}
			}
			for(int i=1;i<n;i++){
				if (list.get(i)!=list.get(i-1)) {
					secondMin=list.get(i);
					break;
				}
			}
			//Send KQ : the same as send studentCode and qCode
			String kq=rq+";"+secondMax+","+secondMin;
			byte[] sendKq=kq.getBytes();
			DatagramPacket dp2=new DatagramPacket(sendKq,sendKq.length,sever,port);
			socket.send(dp2);
			//Close Socket
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
