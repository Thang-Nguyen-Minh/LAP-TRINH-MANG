package REVIEWUDP;
import java.io.*;
import java.util.*;
import java.net.*;
public class DataType_QVWkR86P {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="QVWkR86P";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			//Recevie
			byte[] data=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(data,data.length);
			socket.receive(dp2);
			//input
			String input=new String(dp2.getData(),0,dp2.getLength());
			System.out.println(input);
			String[] p=input.split(";",2);
			String rq=p[0];
			System.out.println(p[0]);
			System.out.println(p[1]);
			String[] num=p[1].split(",");
			List<Integer> list=new ArrayList<>();
			for(String x:num) list.add(Integer.parseInt(x));
			//Sắp xếp xong so sánh 2 thg đầu và 2 thg cuối
			//Khác thì lấy thg đứng sau hoặc đứng trước
			int secondMax=0,secondMin=0;
			Collections.sort(list);
			for(int i=list.size()-1;i>=1;i--){
				if(list.get(i)!=list.get(i-1)){
					secondMax=list.get(i-1);
					break;
				}
			}
			for(int i=1;i<list.size();i++){
				if(list.get(i)!=list.get(i-1)){
					secondMin=list.get(i);
					break;
				}
			}
			//Send KQ
			String kq=rq+";"+secondMax+","+secondMin;
			byte[] sendkq=kq.getBytes();
			DatagramPacket kqq=new DatagramPacket(sendkq,sendkq.length,sever,port);
			socket.send(kqq);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
