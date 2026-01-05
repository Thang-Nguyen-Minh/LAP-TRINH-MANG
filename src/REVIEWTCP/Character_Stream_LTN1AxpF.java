package REVIEWTCP;
import java.io.*;
import java.net.*;
import java.util.*;
public class Character_Stream_LTN1AxpF {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2208;
		String studentCode="B22DCVT525";
		String qCode="LTN1AxpF";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sendCode=studentCode+";"+qCode;
			writer.write(sendCode);
			writer.newLine();
			writer.flush();
			String input=reader.readLine();
			String[] a=input.split(",\\s*");
			List<String> edu=new ArrayList<>();
			for(String x:a){
				if(x!=null && x.trim().toLowerCase().endsWith(".edu")) edu.add(x);
			}
			String kq=String.join(", ",edu);
			writer.write(kq);
			writer.newLine();
			writer.flush();
			reader.close();
			writer.close();
			socket.close();
		}
	}
}
