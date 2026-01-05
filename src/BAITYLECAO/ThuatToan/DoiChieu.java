package BAITYLECAO.ThuatToan;

public class DoiChieu {
	public static void main(String[] args){
		int[] a={1,5,2,3,3,8,9};
		int dc=0,prev=0,dbt=0;
		for(int i=1;i<a.length;i++){
			int diff=a[i]-a[i-1];
			dbt+=Math.abs(diff);
			//prev và diff ngược dấu => số lần đổi chiều tăng thêm 1
			if(diff>0){//prev tăng => prev=1
				if(prev<0) ++dc;
				prev=1;
			}
			else if (diff<0){//prev giảm => prev=-1
				if(prev>0) ++dc;
				prev=-1;
			}
		}
		System.out.println(dc+";"+dbt);
	}
}
