package ONTHITCP;
import java.io.*;
import java.util.*;
import java.net.*;

public class Data_Stream_m6tATnSP {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2207;
		String msv="B22DCVT525";
		String qc="m6tATnSP";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			String sd=msv+";"+qc;
			out.writeUTF(sd);
			out.flush();
			String chuoi=in.readUTF();
			int s=in.readInt();
			// Đảm bảo s nằm trong khoảng 0-25 để tính toán chính xác
			int shift=s%26;
			String kq="";
			for(char x:chuoi.toCharArray()){
				if(x>='A' && x<='Z'){
					// Giải mã: Dịch ngược về bên trái (Trừ shift)
					//Dịch xuôi : (x-'A'+shift+26)%26+'A'
					char rs=(char) ((x-'A'-shift+26)%26+'A');
					kq+=rs;
				}
				else if(x>='a' && x<='z'){
					char rs=(char) ((x-'a'-shift+26)%26+'a');
					kq+=rs;
				}
				else kq+=x;
			}
			out.writeUTF(kq);
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}
}
