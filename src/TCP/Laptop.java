package TCP;

import java.io.Serializable;

public class Laptop implements Serializable {
	int id;
	String code;
	String name;
	int quantity;
	private static final long serialVersionUID = 20150711L;
	public void Solve(){
		this.name=fixName(this.name);
		this.quantity=fixQ(this.quantity);
	}
	public String fixName(String s){
		String[] a=s.split("\\s+");
		String cuoi=a[0];
		String dau=a[a.length-1];
		String giua="";
		for(int i=1;i<a.length-1;i++){
			giua+=a[i]+" ";
		}
		return dau+" "+giua.trim()+" "+cuoi;
	}
	public int fixQ(int n){
		String kq="";
		while (n>0){
			kq+=n%10;
			n/=10;
		}
		return Integer.parseInt(kq);
	}
}
