package UDPPP;
import java.io.*;
public class Student implements Serializable{
	private static final long serialVersionUID = 20171107;
	String id,code,name,email;
	public Student(String id, String code, String name, String email){
		this.id=id;
		this.code=code;
		this.name=name;
		this.email=email;
	}
	public Student(String code){
		this.code=code;
	}
	void Solve(){
		this.name=fixName(this.name);
		this.email=fixMail(this.name);
	}
	String fixName(String s){
		String[] word=s.split("\\s+");
		String kq="";
		for(String w:word){
			if(!w.isEmpty()) kq+=w.substring(0,1).toUpperCase()+w.substring(1).toLowerCase()+" ";
		}
		return kq.trim();
	}
	String fixMail(String s){
		String[] word=s.split("\\s+");
		String ten=word[word.length-1].toLowerCase();
		String kq="";
		for(int i=0;i<word.length-1;i++){
			if(!word[i].isEmpty()) kq+=word[i].substring(0,1).toLowerCase();
		}
		return ten+kq+"@ptit.edu.vn";
	}
}
