package ONTHITCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class W4sd0hJs_TCP_Character_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2208;
		String msv="B22DCVT525";
		String qc="W4sd0hJs";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sd=msv+";"+qc;
			writer.write(sd);
			writer.newLine();
			writer.flush();
			String input= reader.readLine();
			Set<Character> set=new HashSet<>();
			String kq="";
			for(char x:input.toCharArray()){
				if(Character.isLetter(x)){
					if(!set.contains(x)){
						//Cho vào kết quả trước rồi mới cho vào set
						kq+=x;
						set.add(x);
					}
				}
			}
			writer.write(kq);
			writer.newLine();
			writer.flush();
		}
	}
}
