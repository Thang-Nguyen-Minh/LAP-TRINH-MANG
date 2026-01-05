package TCP;
import java.io.*;

public class Customer implements Serializable {
	int id;
	String code,name,dayOfBirth,userName;
	private static final long serialVersionUID = 20170711L;
	Customer(int id,String code,String name,String dayOfBirth,String userName){
		this.id=id;
		this.code=code;
		this.name=name;
		this.dayOfBirth=dayOfBirth;
		this.userName=userName;
	}
	void Solve(){
		String tmp=this.name;
		this.name=fixName(this.name);
		this.dayOfBirth=fixDob(this.dayOfBirth);
		this.userName=fixUser(tmp);
	}
	String fixName(String s){
		String[] a=s.split("\\s+");
		String kq="";
		for(int i=0;i<a.length-1;i++){
			if(!a[i].isEmpty()){
				kq+=a[i].substring(0,1).toUpperCase()+a[i].substring(1).toLowerCase()+" ";
			}
		}
		return a[a.length-1].toUpperCase()+", "+kq.trim();
	}
	String fixDob(String s){
		String[] a=s.split("-");
		return a[1]+"/"+a[0]+"/"+a[2];
	}
	String fixUser(String s){
		String[] a=s.split("\\s+");
		String kq="";
		for(int i=0;i<a.length-1;i++){
			if(!a[i].isEmpty()){
				kq+=a[i].substring(0,1).toLowerCase();
			}
		}
		return kq.trim()+a[a.length-1].toLowerCase();
	}
}
