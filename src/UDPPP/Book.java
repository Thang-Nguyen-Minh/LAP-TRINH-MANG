package UDPPP;
import java.io.*;
public class Book implements Serializable{
	private static final long serialVersionUID = 20251107L;
	String id,title,author,isbn,publishDate;
	public Book(String id, String title, String author, String isbn, String publishDate){
		this.id=id;
		this.title=title;
		this.author=author;
		this.isbn=isbn;
		this.publishDate=publishDate;
	}
	void Solve(){
		this.title=fixTitle(this.title);
		this.author=fixAuthor(this.author);
		this.isbn=fixIsbn(this.isbn);
		this.publishDate=fixNs(this.publishDate);
	}

	String fixTitle(String s){
		String[] word=s.split("\\s+");
		String kq="";
		for(String w:word){
			if(!w.isEmpty()){
				kq+=w.substring(0,1).toUpperCase()+w.substring(1).toLowerCase()+" ";
			}
		}
		return kq.trim();
	}

	String fixAuthor(String s){
		String[] word=s.split("\\s+");
		String ten=word[0].toUpperCase();
		String kq="";
		for(int i=1;i<word.length;i++){
			if(!word[i].isEmpty()){
				kq+=word[i].substring(0,1).toUpperCase()+word[i].substring(1).toLowerCase()+" ";
			}
		}
		return ten+", "+kq.trim();
	}
	String fixIsbn(String s){
		return s.substring(0,3)+"-"+s.substring(3,4)+"-"+s.substring(4,6)+"-"+s.substring(6,12)+"-"+s.charAt(s.length()-1);
	}
	String fixNs(String s){
		String[] w=s.split("-");
		return w[1]+"/"+w[0];
	}
}
