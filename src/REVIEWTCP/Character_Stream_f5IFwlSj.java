package REVIEWTCP;
import java.io.*;
import java.util.*;
import java.net.*;
import java.util.stream.*;
public class Character_Stream_f5IFwlSj {
	public static void main(String[] args) throws IOException,SocketTimeoutException{
		String host="203.162.10.109";
		int port=2208;
		String studentCode="B22DCVT525";
		String qCode="f5IFwlSj";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sendCode=studentCode+";"+qCode;
			writer.write(sendCode);
			writer.newLine();
			writer.flush();
			String input=reader.readLine();
			String[] a=input.split("\\s+");
			List<String> x=
					Arrays.stream(a).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
			String kq=String.join(", ",x);
			writer.write(kq);
			writer.newLine();
			writer.flush();
			reader.close();
			writer.close();
			socket.close();
		}
	}
}
