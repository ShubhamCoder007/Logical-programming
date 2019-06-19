import java.io.*;
class RevSubArray
{
	public static int[] reverse(int[] a, int start, int end){
		end = end > a.length ? a.length : end;
		int k = end - 1;
		for(int i = start; i < end; i++){
			if(i >= k)
				break;
			
			int temp = a[i];
			a[i] = a[k];
			a[k] = temp;
			k--;
		}
		return a;
	}
	
	public static int[] subReverse(int[] a, int k){
		int i = 0;
		for(; i < a.length; i+=k)
			a = reverse(a, i, i + k);
		if(i < a.length)
			a = reverse(a, i, a.length); 
		return a;
	}
	
	public static void display(int[] a){
		System.out.println();
		for(int i : a)
			System.out.print(i+" ");
	}
		
	public static void main(String[] args)throws IOException
	{
		//int[] a = {1,2,3,4,5,6,7,8,9,10};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the sub divisions: ");
		int k = Integer.parseInt(br.readLine());
		System.out.println("Enter the size of the array: ");
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		System.out.println("Enter the elements of the array: ");
		for(int i = 0 ; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());
		
		System.out.println("The array: ");
		display(a);
		
		a = subReverse(a, k);
		
		display(a);
	}
}
