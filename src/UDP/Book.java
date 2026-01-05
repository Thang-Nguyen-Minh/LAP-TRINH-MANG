package UDP;
import java.util.*;
import java.io.*;
import java.net.*;
public class Book implements Serializable{
	String id; String title; String author; String isbn; String publishDate;
	private static final long serialVersionUID = 20251107L;
	public Book(String id, String title, String author, String isbn, String publishDate){
		this.id=id;
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.publishDate=publishDate;
	}
	public void Solve(){
		this.title=fixTitle(this.title);
		this.author=fixAuthor(this.author);
		this.isbn=fixIsbn(this.isbn);
		this.publishDate=fixDate(this.publishDate);
	}
	String fixTitle(String s){
		String[] w=s.split("\\s+");
		String kq="";
		for(String x:w) kq+=x.substring(0,1).toUpperCase()+x.substring(1).toLowerCase()+" ";
		return kq.trim();
	}
	String fixAuthor(String s){
		String[] w=s.split("\\s+");
		String kq="";
		String ho=w[0].toUpperCase();
		for(int i=1;i<w.length;i++) kq+=fixTitle(w[i])+" ";
		return ho+", "+kq.trim();
	}
	String fixIsbn(String s){
		return s.substring(0,3)+"-"+s.substring(3,4)+"-"+s.substring(4,6)+"-"+s.substring(6,12)+"-"+s.substring(12);
	}
	String fixDate(String s){
		String[] w=s.split("-");
		return w[1]+"/"+w[0];
	}
}
