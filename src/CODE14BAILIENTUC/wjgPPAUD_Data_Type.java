package CODE14BAILIENTUC;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class wjgPPAUD_Data_Type {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String msv="b22dcvt525";
		String qc="wjgPPAUD";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			String sd=";"+msv+";"+qc;
			byte[] sc=sd.getBytes();
			DatagramPacket dp1=new DatagramPacket(sc,sc.length,sv,port);
			socket.send(dp1);
			byte[] rec=new byte[8192];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] so=input.split(";");
			String reqId=so[0];
			int n=Integer.parseInt(so[1]);
			int k=Integer.parseInt(so[2]);
			String[] z=so[3].split(",");
			int[] a=new int[n];
			for(int i=0;i<n;i++) a[i]=Integer.parseInt(z[i].trim());
			String max="";
			for(int i=0;i<n-k+1;i++){
				int min=a[i];
				for(int j=0;j<k;j++){
					if(a[i+j]>min) min=a[i+j];
				}
				max+=min+",";
			}
			max=max.substring(0,max.length()-1);
			String kq=reqId+";"+max;
			byte[] sendBack=kq.getBytes();
			DatagramPacket dp3=new DatagramPacket(sendBack,sendBack.length,sv,port);
			socket.send(dp3);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
