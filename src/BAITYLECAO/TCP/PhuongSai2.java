package BAITYLECAO.TCP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;
import java.util.*;
public class PhuongSai2 {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2207;
		String msv="b22dcvt525";
		String qc="minhthang04";
		try(Socket socket=new Socket(host,port)){
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			String sd=msv+";"+qc;
			out.writeUTF(sd);
			out.flush();
			int n=in.readInt();
			int[] a=new int[n];
			for (int i=0;i<n;i++) a[i]=in.readInt();
			int sum=0;
			for(int x:a) sum+=x;
			float tbc=(float) sum/n;
			float ps=0;
			for(int x:a){
				ps+=(x-tbc)*(x-tbc);
			}
			ps/=n;
			out.writeInt(sum);
			out.writeFloat(tbc);
			out.writeFloat(ps);
			out.flush();
		}
	}
}