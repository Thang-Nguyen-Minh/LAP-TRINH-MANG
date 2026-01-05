package UDPPP;

import java.net.*;

public class DataType {
	public static void main(String[] args) {
		//Host,post,studentCode,qCode giống TCP
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="3A0ERGkc";
		try {
			// (a) Tạo socket UDP
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			// Gửi ";studentCode;qCode" : send
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			//DatagramPacket(byte[],int length,InetAddress,port)
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			// (b) Nhận thông điệp "requestId;a1,a2,...,a50" : receive
			byte[] rec=new byte[4096];
			DatagramPacket recPacket=new DatagramPacket(rec,rec.length);
			socket.receive(recPacket);
			String input=new String(recPacket.getData(),0,recPacket.getLength());
			// Parse chuỗi :receceived ở đây là cái nhận được
			String[] parts=input.split(";",2);
			//Tách mảng thành 2 phần là truớc parts[0];và sau ;part[1] chứa các số nguyên
			String rq=parts[0];
			String[] x=parts[1].split(",");
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			for(String k:x){
				int n=Integer.parseInt(k);
				if(n<min) min=n;
				if(n>max) max=n;
			}
			// (c) Gửi lại "requestId;max,min"
			String kq=rq+";"+max+","+min;
			byte[] sendKq=kq.getBytes();
			//DatagramPacket(byte[] buf, int length, InetAddress address, int port)
			DatagramPacket dp2=new DatagramPacket(sendKq,sendKq.length,sever,port);
			socket.send(dp2);
			//(d) Đóng socket
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
