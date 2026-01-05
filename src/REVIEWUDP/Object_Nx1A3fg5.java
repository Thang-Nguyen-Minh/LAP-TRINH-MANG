package REVIEWUDP;
import java.io.*;
import java.net.*;
import java.util.*;
class Product{
	private static final long serialVersionUID = 20161107;
	String id,code,name;
	int quantity;
	public void Solve(){
		this.name=fixName(this.name);
		this.quantity=fixQuantity(this.quantity);
	}
	public String fixName(String s){
		String kq="";
		String[] num=s.split("\\s+");
		kq+=num[num.length-1]+" ";
		for(int i=1;i<num.length-1;i++) kq+=num[i]+" ";
		kq+=num[0]+" ";
		return kq.trim();
	}

	public int fixQuantity(int x){
		int kq=0;
		while(x>0){
			kq=kq*10+x%10;
			x/=10;
		}
		return kq;
	}
}

public class Object_Nx1A3fg5 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2209;
		String stC="B22DCVT525";
		String qC="Nx1A3fg5";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sc=";"+stC+";"+qC;
			byte[] sd=sc.getBytes();
			DatagramPacket dp=new DatagramPacket(sd,sd.length,sever,port);
			socket.send(dp);
			//receive
			byte[] rec=new byte[1024];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			byte[] data=dp2.getData();
			int len=dp2.getLength();
			byte[] reqId=new byte[8];
			System.arraycopy(data,0,reqId,0,8);
			ByteArrayInputStream bais=new ByteArrayInputStream(data,8,len-8);
			ObjectInputStream ois=new ObjectInputStream(bais);
			Product p=(Product) ois.readObject();
			p.Solve();
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(baos);
			oos.writeObject(p);
			oos.flush();
			byte[] objData=baos.toByteArray();
			byte[] sendBack=new byte[objData.length+8];
			System.arraycopy(reqId,0,sendBack,0,8);
			System.arraycopy(objData,0,sendBack,8,objData.length);
			DatagramPacket dp3=new DatagramPacket(sendBack,sendBack.length,sever,port);
			socket.send(dp3);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
