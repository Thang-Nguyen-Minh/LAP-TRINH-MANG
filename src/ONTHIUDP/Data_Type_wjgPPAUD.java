package ONTHIUDP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Data_Type_wjgPPAUD {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String msv="B22DCVT525";
		String qc="wjgPPAUD";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sv=InetAddress.getByName(host);
			//Send
			String sc=";"+msv+";"+qc;
			byte[] sd=sc.getBytes();
			DatagramPacket dp1 = new DatagramPacket(sd,sd.length,sv,port);
			socket.send(dp1);

			//Receive
			byte[] rec=new byte[1024];
			DatagramPacket dp2 = new DatagramPacket(rec,rec.length);
			socket.receive(dp2);

			//Input
			String input=new String(dp2.getData(),0,dp2.getLength()).trim();
			//requestId;5;3;1,5,2,3,4
			String[] tach=input.split(";");
			//tach[0]=requestId
			//tach[1]=5
			//tach[2]=3
			//tach[3]=1,5,2,3,4
			int n=Integer.parseInt(tach[1]);
			int k=Integer.parseInt(tach[2]);
			String[] a1=tach[3].split(",");
			int[] a=new int[n];
			for(int i=0;i<a1.length;i++) a[i]=Integer.parseInt(a1[i].trim());
			//Tìm giá tại lớn nhất trong mỗi cửa sổ trượt kích thước k
			//Tìm từ [i;i+k-1] : 1->1+3-1=3
			//5;3;1,5,2,3,4
			//i=0;i<3;i++
			//cur=1
			//j=1;j<3;j++
			//a[0+1]
			//a[0+2]
			//Tức là so sánh a[0] với a[1] và a[2] rồi cứ tăng dần lên thế => 2 vòng for, cộng chỉ số vào.
			List<String> maxVal=new ArrayList<>();
			for(int i=0;i<n-k+1;i++){
				int curMax=a[i];
				for(int j=1;j<k;j++){
					if(a[i+j]>curMax) curMax=a[i+j];
				}
				maxVal.add(String.valueOf(curMax));
			}
			String kq=tach[0]+";"+String.join(",",maxVal);
			byte[] sendData=kq.getBytes();
			DatagramPacket dp3=new DatagramPacket(sendData,sendData.length,sv,port);
			socket.send(dp3);
			socket.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
