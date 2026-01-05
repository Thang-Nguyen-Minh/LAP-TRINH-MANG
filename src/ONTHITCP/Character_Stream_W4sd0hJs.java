package ONTHITCP;
import java.io.*;
import java.util.*;
import java.net.*;
public class Character_Stream_W4sd0hJs {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2208;
		String msv="B22DCVT525";
		String qC="W4sd0hJs";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sd=msv+";"+qC;
			writer.write(sd);
			writer.newLine();
			writer.flush();
			String input=reader.readLine();
			//Loại ký tự trùng => Dùng HashSet, chưa có thì cho vào (!set.contains(x))
			// Kiểm tra nếu là chữ cái (loại số và ký tự đặc biệt) => Character.isLetter
			StringBuilder sb = new StringBuilder();
			Set<Character> s = new HashSet<>();
			for(char x:input.toCharArray()){
				//Nếu là chữ cái và chưa có trong set. Mỗi thế hết.
				if(Character.isLetter(x)){
					if(!s.contains(x)){
						sb.append(x);
						s.add(x);
					}
				}
			}
			//Gửi lên vẫn là 1 String
			writer.write(sb.toString());
			writer.newLine();
			writer.flush();
			reader.close();
			writer.close();
			socket.close();
		}
	}
}
