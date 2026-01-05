package RMI;

import java.io.Serializable;

public class ProductX implements Serializable {
	String id,code,discountCode;
	int discount;
	private static final long serialVersionUID = 20171107;
	public void Solve(){
		this.discount=fixD(this.discountCode);
	}
	public int fixD(String s){
		int sum=0;
		for(char c:s.toCharArray()){
			if(Character.isDigit(c)) sum+=(c-'0');
		}
		return sum;
	}
}
