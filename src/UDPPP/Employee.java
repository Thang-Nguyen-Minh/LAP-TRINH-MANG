package UDPPP;
import java.io.*;

public class Employee implements Serializable {
	private static final long serialVersionUID = 20261107L;
	String id,name;
	double salary;
	String hireDate;
	public Employee(String id, String name, double salary, String hireDate){
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	void Solve(){
		this.name=fixName(this.name);
		this.salary=fixSalary(this.salary,this.hireDate);
		this.hireDate=fixDate(this.hireDate);
	}
	String fixName(String name){
		String[] word=name.split("\\s+");
		String kq="";
		for(String w:word){
			if(!w.isEmpty()) kq+=w.substring(0,1).toUpperCase()+w.substring(1).toLowerCase()+" ";
		}
		return kq.trim();
	}
	double fixSalary(double salary,String hireDate){
		String[] x = hireDate.split("-");
		int nam=Integer.parseInt(x[0]);
		int tong=0;
		while(nam>0){
			tong+=nam%10;
			nam/=10;
		}
		return salary+salary*1.0*tong/100;
	}
	String fixDate(String s){
		String[] x = s.split("-");
		return x[2]+"/"+x[1]+"/"+x[0];
	}
}

