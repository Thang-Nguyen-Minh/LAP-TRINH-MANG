package CODE14BAILIENTUC;

import java.net.Socket;
import java.io.*;
import java.util.*;
public class W4sd0hJs_Character_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2208;
		String msv="b22dcvt525";
		String qc="W4sd0hJs";
		try(Socket socket=new Socket(host,port)){
			BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String sd=msv+";"+qc;
			writer.write(sd);
			writer.newLine();
			writer.flush();
			String s = reader.readLine();
			Set<Character> set=new HashSet<>();
			String kq="";
			for(char w:s.toCharArray()){
				if(Character.isLetter(w)){
					if(!set.contains(w)){
						kq+=w;
						set.add(w);
					}
				}
			}
			writer.write(kq);
			writer.newLine();
			writer.flush();
		}
	}
}
