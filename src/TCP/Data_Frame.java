package TCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Data_Frame {
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
			int n=in.readInt();
			String bin=Integer.toBinaryString(n);
			String hex=Integer.toHexString(n);
			String kq=bin+";"+hex.toUpperCase();
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
