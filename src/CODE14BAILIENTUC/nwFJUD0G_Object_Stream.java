package CODE14BAILIENTUC;

import TCP.Laptop;

import java.net.Socket;
import java.io.*;
import java.util.*;
public class nwFJUD0G_Object_Stream {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=2209;
		String msv="b22dcvt525";
		String qc="nwFJUD0G";
		try(Socket socket=new Socket(host,port)){
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			String sd=msv+";"+qc;
			out.writeObject(sd);
			out.flush();
			Laptop laptop=(Laptop) in.readObject();
			laptop.Solve();
			out.writeObject(laptop);
			out.flush();
		}
	}
}
