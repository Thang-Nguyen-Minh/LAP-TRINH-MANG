package UDP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Object_Frame {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2209;
		String stc="B22DCVT525";
		String qc="02QUMv1x";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sc=";"+stc+";"+qc;
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
