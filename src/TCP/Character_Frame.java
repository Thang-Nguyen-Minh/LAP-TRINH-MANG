package TCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Character_Frame {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String stc="B22DCVT525";
		String qc="7u9io2a8";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sc=stc+";"+qc;
			out.write(sc);
			out.newLine();
			out.flush();
			String input=in.readLine();
			Set<Character> se=new LinkedHashSet<>();
			String kq="";
			for(char x:input.toCharArray()){
				if(Character.isLetter(x) && !se.contains(x)){
					kq+=x;
					se.add(x);
				}
			}
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
