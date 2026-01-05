package TCPPP;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;
public class CharacterStream3 {
	public static void main(String[] args) throws IOException,ClassNotFoundException,SocketTimeoutException{
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
			System.out.println("Send code: "+sendCode);
			String input=reader.readLine();
			//Solve
			String[] a=input.split("\\s+");
			List<String> words=
					Arrays.stream(a).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
			String kq=String.join(", ",words);
			writer.write(kq.trim());
			writer.newLine();
			writer.flush();
			System.out.println("Kq: "+kq.trim());
			reader.close();
			writer.close();
			socket.close();
		}
	}
}
