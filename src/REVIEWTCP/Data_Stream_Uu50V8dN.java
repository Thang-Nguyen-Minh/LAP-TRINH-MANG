package REVIEWTCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Data_Stream_Uu50V8dN {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2207;
		String studentCode="B22DCVT525";
		String qCode="Uu50V8dN";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			DataInputStream in=new DataInputStream(socket.getInputStream());
			DataOutputStream out=new DataOutputStream(socket.getOutputStream());
			String sendCode=studentCode+";"+qCode;
			out.writeUTF(sendCode);
			out.flush();
			String input=in.readUTF();
			System.out.println(input);
			String[] a=input.split(",");
			List<Integer> list=new ArrayList<>();
			for(String x:a){
				x=x.trim();
				if(!x.isEmpty()) list.add(Integer.parseInt(x));
			}
			int dc=0,dbt=0;
			int prev=0;
			int n=list.size();
			for(int i=1;i<n;i++){
				int diff=list.get(i)-list.get(i-1);
				if(diff>0){
					if(prev<0) ++dc;
					prev=1;
				}
				else if(diff<0){
					if(prev>0) ++dc;
					prev=-1;
				}
			}
			for(int i=1;i<n;i++) dbt+=Math.abs(list.get(i)-list.get(i-1));
			out.writeInt(dc);
			out.writeInt(dbt);
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
	}
}
