package ONTHITCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class m6tATnSP_TCP_Data_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2207;
		String msv="B22DCVT525";
		String qc="m6tATnSP";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String sd=msv+";"+qc;
			dos.writeUTF(sd);
			dos.flush();
			String chuoi= dis.readUTF();
			int s=dis.readInt();
			s=s%26;
			String kq="";
			for(char x:chuoi.toCharArray()){
				if(x>='A' && x<='Z'){
					char en=(char) ((x-'A'-s+26)%26+'A');
					kq+=en;
				}
				else if(x>='a' && x<='z'){
					char en=(char) ((x-'a'-s+26)%26+'z');
					kq+=en;
				}
				else kq+=x;
			}
			System.out.println(kq);
			dos.writeUTF(kq);
			dos.flush();
			dis.close();
			dos.close();
			socket.close();
		}
	}
}
