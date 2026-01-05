package UDP;
import java.io.*;

public class Product implements Serializable{
	String id,code,name;
	int quantity;
	private static final long serialVersionUID = 20161107;
	Product(String id,String code,String name,int quantity){
		this.id=id;
		this.name=name;
		this.code=code;
		this.quantity=quantity;
	}
	void Solve(){
		this.name=fixName(this.name);
		this.quantity=fixQ(this.quantity);
	}
	String fixName(String s){
		String[] a=s.split("\\s+");
		String dau=a[a.length-1];
		String cuoi=a[0];
		String giua="";
		for(int i=1;i<a.length-1;i++) giua+=a[i]+" ";
		return dau+" "+giua.trim()+" "+cuoi;
	}
	int fixQ(int x){
		int kq=0;
		while(x>0){
			kq=kq*10+x%10;
			x/=10;
		}
		return kq;
	}
}
