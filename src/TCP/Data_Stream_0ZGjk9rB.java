package TCP;
import java.io.*;
import java.net.*;
public class Data_Stream_0ZGjk9rB {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2207;
		String stc="B22DCVT525";
		String qc="0ZGjk9rB";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			String sc=stc+";"+qc;
			out.writeUTF(sc);
			out.flush();
			int input=in.readInt();
			// c. Chuyển đổi sang hệ nhị phân và hệ thập lục phân
			String binary=Integer.toBinaryString(input);
			String hex=Integer.toHexString(input).toUpperCase();
			String kq=binary+";"+hex;
			out.writeUTF(kq);
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
