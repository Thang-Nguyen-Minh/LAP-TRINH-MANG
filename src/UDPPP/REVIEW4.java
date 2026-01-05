package UDPPP;
import java.util.*;
import java.net.*;

public class REVIEW4 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String stc="B22DCVT525";
		String qc="QVWkR86P";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress ip=InetAddress.getByName(host);
			String sc=";"+stc+";"+qc;
			byte[] sd=sc.getBytes();
			DatagramPacket dp=new DatagramPacket(sd,sd.length,ip,port);
			socket.send(dp);
			byte[] rec=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] word=input.split(";",2);
			String[] x=word[1].split(",");
			List<Integer> list=new ArrayList<>();
			for(String a:x) list.add(Integer.parseInt(a));
			int secondMax=0,secondMin=0;
			Collections.sort(list);
			int n=list.size();
			for(int i=n-1;i>=1;i--){
				if(list.get(i)!=list.get(i-1)){
					secondMax=list.get(i-1);
					break;
				}
			}
			for(int i=1;i<n;i++){
				if(list.get(i)!=list.get(i-1)){
					secondMin=list.get(i);
					break;
				}
			}
			String kq=word[0]+";"+secondMax+","+secondMin;
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
