package BAITYLECAO.ThuatToan;

public class ChuanHoa2 {
	public static void main(String[] args){
		String s = "aaaabbccdefgghhhh";
		String kq=chuanHoa(s);
		System.out.println(kq);
	}
	public static String chuanHoa(String s){
		String kq="";
		int cnt=1;
		for(int i=1;i<=s.length();i++){
			if(i<s.length() && s.charAt(i)==s.charAt(i-1)) ++cnt;
			else{
				kq+=s.charAt(i-1);
				if(cnt>1) kq+=cnt;
				cnt=1;
			}
		}
		return kq;
	}
}
