package ONTHITCP;
import java.net.*;
import java.io.*;
import java.util.*;
import TCP.Laptop;
public class Object_Stream_nwFJUD0G {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2209;
		String msv="B22DCVT525";
		String qC="nwFJUD0G";
		try(Socket socket=new Socket(host,port)){
			socket.setSoTimeout(5000);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			String sd=msv+";"+qC;
			oos.writeObject(sd);
			oos.flush();
			Laptop laptop=(Laptop) ois.readObject();
			laptop.Solve();
			oos.writeObject(laptop);
			oos.flush();
			ois.close();
			oos.close();
			socket.close();
		}
	}
}
