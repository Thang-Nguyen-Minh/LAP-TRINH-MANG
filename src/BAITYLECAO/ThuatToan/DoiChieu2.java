package BAITYLECAO.ThuatToan;

public class DoiChieu2 {
	public static void main(String[] args){
		int[] a={1,2,3,2,1,4,5,6};
		int dc=0,dbt=0,prev=0;
		for(int i=1;i<a.length;i++){
			int diff=a[i]-a[i-1];
			dbt+=Math.abs(diff);
			if(diff>0){
				if(prev<0) ++dc;
				prev=1;
			}
			else if (diff<0){
				if(prev>0) ++dc;
				prev=-1;
			}
		}
		System.out.println(dc+";"+dbt);
	}
}
