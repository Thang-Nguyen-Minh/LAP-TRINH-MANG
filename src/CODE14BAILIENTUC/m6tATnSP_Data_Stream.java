package CODE14BAILIENTUC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class m6tATnSP_Data_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2207;
		String msv="b22dcvt525";
		String qc="m6tATnSP";
		try(Socket socket=new Socket(host,port)){
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(msv+";"+qc);
			out.flush();
			String chuoi = in.readUTF();
			int s=in.readInt();
			s=s%26;
			String kq="";
			for(int i=0;i<chuoi.length();i++){
				char p=chuoi.charAt(i);
				if(p>='A' && p<='Z'){
					char en=(char) ((p-'A'-s+26)%26+'A');
					kq+=en;
				}
				else if(p>='a' && p<='z'){
					char en=(char) ((p-'a'-s+26)%26+'a');
					kq+=en;
				}
				else kq+=p;
			}
			out.writeUTF(kq);
			out.flush();
		}
	}
}
