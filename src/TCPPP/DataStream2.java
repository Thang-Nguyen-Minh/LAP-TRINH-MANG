package TCPPP;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataStream2 {
	public static void main(String[] args) throws IOException ,SocketTimeoutException{
		String host = "203.162.10.109";
		int port = 2207;
		String studentCode="B22DCVT525";
		String qCode="RDvLnD8A";
		try(Socket socket=new Socket(host,port)){
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			String sendCode=studentCode+";"+qCode;
			out.writeUTF(sendCode);
			out.flush();
			int k=in.readInt();
			String input = in.readUTF();
			//c. Thực hiện chia mảng
			String[] a=input.split(",");
			List<Integer> list=new ArrayList<>();
			for(String x:a) list.add(Integer.parseInt(x.trim()));
			int n=list.size();
			for(int i=0;i<n;i+=k){
				int start=i;
				int end=Math.min(i+k-1,n-1);
				while(start<end){
					Collections.swap(list,start,end);
					start++;
					end--;
				}
			}
			String kq="";
			for(int i=0;i<n;i++){
				if(i<n-1) kq+=list.get(i)+",";
				else kq+=list.get(i);
			}
			out.writeUTF(kq);
			out.flush();
			out.close();
			in.close();
			socket.close();
		}
	}
}
