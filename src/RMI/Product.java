package RMI;
import java.io.*;
import java.util.*;
public class Product implements Serializable{
	public String id,code;
	public double importPrice;
	public double exportPrice;
	private static final long serialVersionUID = 20151107L;
	Product() {
	}

	public Product(String id, String code,double ImportPrice, double ExportPrice){
		this.id=id;
		this.code=code;
		this.importPrice=ImportPrice;
		this.exportPrice=ExportPrice;
	}
	public void Solve(){
		this.code=this.code.toUpperCase();
		this.importPrice=this.importPrice;
		this.exportPrice=this.importPrice+this.importPrice*0.2;
	}
}
