package BAITYLECAO.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SoLanXuatHienMax {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String msv="b22dcvt525";
		String qc="minhthang04";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			String sd=";"+msv+";"+qc;
			byte[] sD=sd.getBytes();
			DatagramPacket dp1=new DatagramPacket(sD,sD.length,sv,port);
			socket.send(dp1);
			//Receive
			byte[] rec=new byte[8192];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			//Nhận input là 1 String
			//Tìm ra ký tự xuất hiện max và in ra vị trí xuất hiện
			String input=new String(dp2.getData(),0,dp2.getLength());
			String[] x=input.split(";",2);
			String reqId=x[0];
			String s = x[1];
			int[] cnt=new int[1000001];
			int maxVal=Integer.MIN_VALUE;
			char kytuMax=0;
			for(char c:s.toCharArray()){
				cnt[c]++;
			}
			for (char c:s.toCharArray()){
				if(cnt[c]>maxVal){
					maxVal=cnt[c];
					kytuMax=c;
				}
			}
			String kq="";
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)==kytuMax) kq+=i+",";
			}
			kq=kq.substring(0,kq.length()-1);
			String kq2=reqId+";"+kq;
			byte[] sendData=kq2.getBytes();
			DatagramPacket dp3=new DatagramPacket(sendData,sendData.length,sv,port);
			socket.send(dp3);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
