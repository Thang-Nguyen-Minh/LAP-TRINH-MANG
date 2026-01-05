package RMIClient;
import java.rmi.*;
import java.rmi.registry.*;
import RMI.DataService;
import java.util.*;
public class Data_SfjzO8UZ {
	public static void main(String[] args) throws Exception{
		String host="203.162.10.109";
		int port=1099;
		String stc="B22DCVT525";
		String qc="SfjzO8UZ";
		Registry rs=LocateRegistry.getRegistry(host,port);
		DataService ds=(DataService) rs.lookup("RMIDataService");
		//Data => đầu vao là Object => convert toString()
		String input=ds.requestData(stc,qc).toString();
		String[] parts=input.split("\\s*,\\s*");
		int[] a=new int[parts.length];
		for(int i=0;i<parts.length;i++) a[i]=Integer.parseInt(parts[i]);
		// 6️⃣ Thuật toán sinh tổ hợp kế tiếp (next permutation)
		nextPermutaiton(a);
		// 7️⃣ Ghép lại chuỗi kết quả theo đúng format "x,y,z"
		String kq="";
		for(int i=0;i<a.length;i++){
			kq+=a[i]+",";
		}
		kq=kq.substring(0,kq.length()-1);
		ds.submitData(stc,qc,kq);
	}
	public static void nextPermutaiton(int a[]){
		int n=a.length;
		//1. Tìm i là vị trí đầu tiên từ cuối mà a[i] < a[i+1]
		int i=n-2;
		while(i>=0 && a[i]>=a[i+1]) --i;
		if(i>=0){
			//2. Tìm j là phần tử nhỏ nhâ bên phải i mà lớn hơn a[i]
			int j=n-1;
			while(a[j]<=a[i]) --j;
			//3. Hoán đổi a[i] và a[j];
			swap(a,i,j);
		}
		//4. Đảo ng ược đoạn sau  để có thứ tự nhỏ nhất
		reverse(a,i+1,n-1);
	}
	public static void swap(int a[],int l,int r){
		int tmp=a[l];
		a[l]=a[r];
		a[r]=tmp;
	}
	public static void reverse(int[] a,int l,int r){
		while(l<r){
			swap(a,l++,r--);
		}
	}
}
