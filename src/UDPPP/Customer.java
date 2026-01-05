package UDPPP;
import java.io.*;
public class Customer implements Serializable {
	private static final long serialVersionUID = 20151107;
	String id,code,name,dayOfBirth,userName;

	Customer(String id,String code,String name,String dayOfBirth,String username ){
		this.id=id;
		this.code=code;
		this.name=name;
		this.dayOfBirth=dayOfBirth;
		this.userName=username;
	}

	void Solve(){
		String tmp=this.name;
		this.name=fixName(this.name);
		this.dayOfBirth=fixNs(this.dayOfBirth);
		this.userName=fixTk(tmp);
	}

	String fixName(String s){
		String[] x=s.split("\\s+");
		String kq="";
		String z=x[x.length-1].toUpperCase();
		for(int i=0;i<x.length-1;i++){
			if(!x[i].isEmpty()) kq+=x[i].substring(0,1).toUpperCase()+x[i].substring(1).toLowerCase()+" ";
		}
		return z+", "+kq.trim();
	}
	String fixNs(String s){
		String[] word=s.split("-");
		return word[1]+"/"+word[0]+"/"+word[2];
	}
	String fixTk(String s){
		String[] x=s.split(" ");
		String tmp=x[x.length-1].toLowerCase();
		String kq="";
		for(int i=0;i<x.length-1;i++){
			if(!x[i].isEmpty()) kq+=x[i].substring(0,1).toLowerCase();
		}
		return kq+tmp;
	}
}
