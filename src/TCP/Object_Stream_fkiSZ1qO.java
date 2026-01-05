package TCP;
import java.io.*;
import java.net.*;
public class Object_Stream_fkiSZ1qO {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2209;
		String stc="B22DCVT525";
		String qc="fkiSZ1qO";
		try(Socket socket=new Socket(host,port)){
			ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
			String sc=stc+";"+qc;
			out.writeObject(sc);
			out.flush();
			Customer c=(Customer) in.readObject();
			c.Solve();
			out.writeObject(c);
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
