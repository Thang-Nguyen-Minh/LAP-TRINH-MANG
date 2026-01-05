package RMI;
import java.io.*;
import java.util.*;
public class Student implements Serializable{
	public String id,name;
	public int enrollmentYear;
	public String code;
	private static final long serialVersionUID = 20241130L;
	public Student(){}
	public Student(String id, String name, int enrollmentYear){
		this.id=id;
		this.name=name;
		this.enrollmentYear=enrollmentYear;
	}
	public void Solve(){
		this.code=fixCode(this.enrollmentYear,this.name);
		this.name=fixName(this.name);
	}
	public String fixCode(int year,String name){
		String kq="B";
		kq+=String.valueOf(year).substring(2);
		String[] a=name.split("\\s+");
		kq+=a[a.length-1].toUpperCase();
		kq+="_";
		for(int i=0;i<a.length-1;i++){
			if(!a[i].isEmpty()){
				kq+=a[i].substring(0,1).toUpperCase();
			}
		}
		return kq.trim();
	}
	public String fixName(String name){
		String kq="";
		String[] a=name.split("\\s+");
		for(int i=0;i<a.length;i++){
			if(!a[i].isEmpty()){
				kq+=a[i].substring(0,1).toUpperCase()+a[i].substring(1).toLowerCase()+" ";
			}
		}
		return kq.trim();
	}
}
