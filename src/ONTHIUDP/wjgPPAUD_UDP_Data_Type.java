package ONTHIUDP;
import java.io.*;
import java.util.*;
import java.net.*;
public class wjgPPAUD_UDP_Data_Type {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String msv="B22DCVT525";
		String qc="wjgPPAUD";
		try {
			DatagramSocket socket=new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			String sd=";"+msv+";"+qc;
			byte[] bytes=sd.getBytes();
			DatagramPacket dp1=new DatagramPacket(bytes,bytes.length,sv,port);
			socket.send(dp1);
			byte[] rec = new byte[8192];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] a=input.split(";");
			String reqId=a[0];
			int n=Integer.parseInt(a[1]);
			int k=Integer.parseInt(a[2]);
			String[] pt=a[3].split(",");
			List<Integer> list=new ArrayList<>();
			for(String x:pt) list.add(Integer.parseInt(x));
			String kq="";
			for(int i=0;i<n-k+1;i++){
				int min=list.get(i);
				//Để j=0 để đảm bảo luôn so sánh với đủ số lượng k.
				for (int j=0;j<k;j++){
					if(list.get(i+j)>min) min=list.get(i+j);
				}
				kq+=min+",";
			}
			/*
			5;3;1,5,2,3,4.
			0->5-3+1=3 -> i = 0,1,2
			j=i+1;j<3;j++
			a[0], a[1], a[2]
			min=a[1]
			j=2;j<2
			a[1],a[2],a[3]
			i=2
			a[2],j=3>k
			 */
			kq=kq.substring(0,kq.length()-1);
			System.out.println(kq);
			String kqq=reqId+";"+kq;
			byte[] sendBack=kqq.getBytes();
			DatagramPacket dp3=new DatagramPacket(sendBack,sendBack.length,sv,port);
			socket.send(dp3);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
