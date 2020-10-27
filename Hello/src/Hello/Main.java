package Hello;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int[] a= new int [1000];
		int n;
		int res=0;
		try (Scanner dm = new Scanner(System.in)) {
			n= dm.nextInt();
			for(int i=0; i<n; i++) {
				a[i]= dm.nextInt();
			}
		}
		for(int i=1;i<n;i++) {
			int j=i;
			int x=a[i];
			while(j>0 && a[j-1]>x) {
				a[j]=a[j-1];
				j--;
				res++;
			}
			a[j]=x;
		}
		for(int i=0; i<n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.printf("%n");
        System.out.print(res);
	}

}
