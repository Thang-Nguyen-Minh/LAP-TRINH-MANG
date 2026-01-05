package BAITYLECAO.UDP;
import java.io.*;
import java.net.*;
import java.util.*;
public class SoLanXuatHienMax2 {
	public static void main(String[] arg){
		String host="203.162.10.109";
		int port=2207;
		String msv="b22dcvt525";
		String qc="minhthang04";
		try{
			DatagramSocket socket = new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			String sd=";"+msv+";"+qc;
			byte[] sc=sd.getBytes();
			DatagramPacket dp1 = new DatagramPacket(sc,sc.length,sv,port);
			socket.send(dp1);
			byte[] rec=new byte[8192];
			DatagramPacket dp2= new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			String input = new String(dp2.getData(),0,dp2.getLength());
			int[] cnt=new int[1000001];
			for(char c:input.toCharArray()) cnt[c]++;
			int maxVal=Integer.MIN_VALUE;
			char kytuMax=0;
			for(char c:input.toCharArray()){
				if(cnt[c]>maxVal){
					maxVal=cnt[c];
					kytuMax=c;
				}
			}
			String kq="";
			for(int i=0;i<input.length();i++){
				if(input.charAt(i)==kytuMax) kq+=i+",";
			}
			kq=kq.substring(0,kq.length()-1);
			String rs=kytuMax+";"+kq;
			byte[] sendBack=rs.getBytes();
			DatagramPacket dp3=new DatagramPacket(sendBack,sendBack.length,sv,port);
			socket.send(dp3);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
