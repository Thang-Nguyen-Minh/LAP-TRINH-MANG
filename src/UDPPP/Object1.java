package UDPPP;
import java.io.*;
import java.net.*;

public class Object1 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2209;
		String studentCode="B22DCVT525";
		String qCode="Nx1A3fg5";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress sever=InetAddress.getByName(host);
			String sendCode=";"+studentCode+";"+qCode;
			byte[] sendData=sendCode.getBytes();
			DatagramPacket dp=new DatagramPacket(sendData,sendData.length,sever,port);
			socket.send(dp);
			byte[] rec=new byte[4096];
			DatagramPacket recPac=new DatagramPacket(rec,rec.length);
			socket.receive(recPac);
			//8 byte đầu là requestId
			byte[] data=recPac.getData();
			int len=recPac.getLength();
			byte[] reqId=new byte[8];
			System.arraycopy(data,0,reqId,0,8);
			String rq=new String(reqId);
			//Các byte còn lại là object Product
			ByteArrayInputStream bais=new ByteArrayInputStream(data,8,len-8);
			ObjectInputStream ois=new ObjectInputStream(bais);
			Product product=(Product) ois.readObject();
			//Solve
			String newName="";
			String name=product.getName();
			String[] rs=name.split("\\s+");
			newName+=rs[rs.length-1]+" ";
			for(int i=1;i<rs.length-1;i++) newName+=rs[i]+" ";
			newName+=rs[0]+" ";
			product.setName(newName.trim());
			System.out.println(newName);
			int kq=0;
			int x=product.getQuantity();
			System.out.println(x);
			while(x>0){
				kq=kq*10+x%10;
				x/=10;
			}
			product.setQuantity(kq);
			// Gửi lại cho server (reqId + object)
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(baos);
			oos.writeObject(product);
			oos.flush();
			byte[] objData=baos.toByteArray();
			byte[] sendBack=new byte[8+objData.length];
			System.arraycopy(reqId,0,sendBack,0,8);
			System.arraycopy(objData,0,sendBack,8,objData.length);
			DatagramPacket sendPacket=new DatagramPacket(sendBack,sendBack.length,sever,port);
			socket.send(sendPacket);
			oos.close();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
