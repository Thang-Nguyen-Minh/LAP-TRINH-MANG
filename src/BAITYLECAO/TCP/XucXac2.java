package BAITYLECAO.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class XucXac2 {
	public static void main(String[] arg) throws Exception{
		String host="203.162.10.109";
		int port=2207;
		String msv="b22dcvt525";
		String qc="pm6YFBp2";
		try(Socket socket=new Socket(host,port)){
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msv+";"+qc);
			dos.flush();
			int n=dis.readInt();
			int[] cnt=new int[n];
			for(int i=0;i<n;i++){
				int val=dis.readInt();
				if(val>=1 && val<=6) cnt[val]++;
			}
			for(int i=1;i<=6;i++){
				float xs=(float) cnt[i]/n;
				dos.writeFloat(xs);
			}
			dos.flush();
			dis.close();
			dos.close();
			socket.close();
		}
	}
}
