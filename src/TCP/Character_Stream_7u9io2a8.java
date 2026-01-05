package TCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Character_Stream_7u9io2a8 {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String stc="B22DCVT525";
		String qc="7u9io2a8";
		try(Socket socket=new Socket(host,port)){
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sc=stc+";"+qc;
			out.write(sc);
			out.newLine();
			out.flush();
			String input=in.readLine();
			String kq="";
			Set<Character> se=new LinkedHashSet<>();
			for(char c:input.toCharArray()){
				if(Character.isLetter(c) && !se.contains(c)){
					se.add(c);
					kq+=c;
				}
			}
			System.out.println(kq);
			out.write(kq);
			out.newLine();
			out.flush();
			in.close();
			out.close();
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
