package UDPPP;
import java.io.*;
import java.net.*;
public class REVIEW3 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2209;
		String stc="B22DCVT525";
		String qc="kIhNACbe ";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress ip=InetAddress.getByName(host);
			String sc=";"+stc+";"+qc;
			byte[] sd=sc.getBytes();
			DatagramPacket dp=new DatagramPacket(sd,sd.length,ip,port);
			socket.send(dp);
			byte[] rec=new byte[4096];
			DatagramPacket dp2=new DatagramPacket(rec,rec.length);
			socket.receive(dp2);
			byte[] data=dp2.getData();
			int len=dp2.getLength();
			byte[] reqId=new byte[8];
			System.arraycopy(data,0,reqId,0,8);
			ByteArrayInputStream bais=new ByteArrayInputStream(data,8,len-8);
			ObjectInputStream ois=new ObjectInputStream(bais);
			Student st=(Student) ois.readObject();
			st.Solve();
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(baos);
			oos.writeObject(st);
			oos.flush();
			byte[] objData=baos.toByteArray();
			byte[] sendBack=new byte[8+objData.length];
			System.arraycopy(reqId,0,sendBack,0,8);
			System.arraycopy(objData,0,sendBack,8,objData.length);
			DatagramPacket dp3=new DatagramPacket(sendBack,sendBack.length,ip,port);
			socket.send(dp3);
			ois.close();
			oos.close();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
