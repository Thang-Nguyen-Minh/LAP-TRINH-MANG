package CODE14BAILIENTUC;

import UDP.Book;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class NNURxBni_Object {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2209;
		String msv="b22dcvt525";
		String qc="NNURxBni";
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
			byte[] data=dp2.getData();
			int len=dp2.getLength();
			byte[] reqId=new byte[8];
			System.arraycopy(data,0,reqId,0,8);
			ByteArrayInputStream bais = new ByteArrayInputStream(data,8,len-8);
			ObjectInputStream ois = new ObjectInputStream(bais);
			Book book=(Book) ois.readObject();
			book.Solve();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(book);
			oos.flush();
			byte[] objData=baos.toByteArray();
			byte[] sendBack=new byte[objData.length+8];
			System.arraycopy(reqId,0,sendBack,0,8);
			System.arraycopy(objData,0,sendBack,8,objData.length);
			DatagramPacket dp3 = new DatagramPacket(sendBack,sendBack.length,sv,port);
			socket.send(dp3);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
