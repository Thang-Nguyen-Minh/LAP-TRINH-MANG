package REVIEWUDP;
import java.util.*;
import java.net.*;
import java.util.stream.*;
public class TCPINUDP {
	public static void main(String[] args){
		String host="203.162.10.109";
		int port=2208;
		String stC="B22DCVT525";
		String qC="f5IFwlSj";
		try{
			DatagramSocket socket=new DatagramSocket();
			InetAddress ip=InetAddress.getByName(host);
			String sendCode=";"+stC+";"+qC;
			byte[] buf=sendCode.getBytes();
			DatagramPacket packet=new DatagramPacket(buf,buf.length,ip,port);
			socket.send(packet);
			//receive
			byte[] rec=new byte[4096];
			DatagramPacket dp=new DatagramPacket(rec,rec.length);
			socket.receive(dp);
			String input=new String(dp.getData(),0,dp.getLength());
			//Solve
			String[] w=input.split(";");
			String[] tu=w[1].split("\\s+");
			//1. Sắp xếp theo thứ tự xuất hiện và độ dài
			List<String> list=
					Arrays.stream(tu).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
			//2. Sắp xếp String ngược không phân biệt hoa thường
			Arrays.sort(tu,String.CASE_INSENSITIVE_ORDER.reversed());
			/*
			//3. Số lần đổi chiều + biến thiên : dùng gán giá trị = 1 và -1
			//diff=a[i]-a[i-1], so sánh thì khi gán nếu diff>0 prev=1 và ngược lại
			int dc=0,prev=0;
			int n=list.size();
			for(int i=1;i<n;i++){
				int diff=list.get(i)-list.get(i-1);
				if(diff>0){
					if(prev<0) ++dc;
					prev=1;
				}
				else if(diff<0){
					if(prev>0) ++dc;
					prev=-1;
				}
			}
			 */
			/*
			//Đảo ngược mảng theo độ dài k : 2 con trỏ
			//start=i, end=min(i+k-1,n-1) xong swap là được
			int n=list.size();
			for(int i=0;i<k;i++){
				int start=i;
				int end=Math.min(i+k-1,n-1);
				while(start<end){
					Collections.swap(list,start,end);
					++start;--end;
				}
			}
			String kq="";
			for(int i=0;i<n;i++){
				if(i<n-1) kq+=list.get(i)+",";
				else kq+=list.get(i);
			}
			 */
			/*
			//Chuẩn hóa : aabb ⇒ a2b2 : thì cứ so sánh thằng sau với thằng trước thôi
			String kq="";
			int cnt=1;
			for(int i=1;i<s.length();i++){
				if(s.charAt(i)==s.charAt(i-1)) ++cnt;
				else{
					kq+=s.charAt(i-1);
					if(cnt>1) kq+=cnt;
					cnt=1;
				}
			}
			*/
			/*
			 //Tìm vị trí, độ lệch
			//Tinh tong , tao 1 bien cur=num.get(i), tinh sumRight=tong-sumLeft-cur
			//Tinh do lech = abs(sumLeft-sumRight) xong tim min, o min cos bestIndex
			//Tinh xong ms cong sumLeft vs cur, muc tieu vong lap la tim bestIndex va min_diff
			int totalSum=0;
			for(int x:v) totalSum+=x;
			int sumLeft=0,bestIndex=-1,min_diff=Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				int cur=list.get(i);
				int sumRight=totalSum-sumLeft-cur;
				int diff=Math.abs(sumLeft-sumRight);
				if(diff<min_diff){
					min_diff=diff;
					bestIndex=i;
				}
				sumLeft+=cur;
			}
			sumLeft=0;
			int sumRight=0;
			for(int i=0;i<bestIndex;i++) sumLeft+=list.get(i);
			for(int i=bestIndex+1;i<list.size();i++) sumRight+=list.get(i);
			 */
			/*
			//Xác định hai số trong dãy có tổng gần nhất với K :
			//thì cứ lấy k trừ đi 2 cặp số rồi tìm min là được
			int K=1000;//target
			int n1=0,n2=0;
			int min_diff=Integer.MAX_VALUE;
			//Cap so
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					int a=x[i],b=x[j];
					int diff=Math.abs(a+b-K);
					if(diff<min_diff){
						min_diff=diff;
						n1=a;
						n2=b;
					}
				}
			}
			int max=Math.max(n1,n2);
			int min=Math.min(n1,n2);
			 */
			//send
			String kq=String.join(", ",list);
			byte[] x=kq.getBytes();
			DatagramPacket dp2=new DatagramPacket(x,x.length,ip,port);
			socket.send(dp2);
			socket.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
