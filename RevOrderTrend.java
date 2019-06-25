//Reverse the order of the array when they are subsequently following an ascending or a descending trend

import java.io.*;

class RevOrderTrend
{
	static boolean set = false;
	static boolean asc = false;
	static boolean desc = false;
	
	public static int[] reverse(int[] a, int start, int end){
		for(int i = start, j = end; i < j; i++, j--){
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
		}
		return a;
	}
	
	public static int locCordinates(int[] a, int n){
		int end = -1;
		for(int i = n; i < a.length - 1; i++){
			if((a[i] <= a[i+1]) && !asc){
				end = i + 1;
				desc = true;
			}
			
			if((a[i] > a[i+1]) && !desc){
				end = i + 1;
				asc = true;
			}
			
			if(!asc && !(a[i] <= a[i+1]) || !(a[i] > a[i+1]) && !desc)
				break;
		}
		
		desc = false;
		asc = false;
		set = false;
		
		return end;
	}
				
			
		
	public static int[] revTrend(int[] a){
		int start = -1;
		int end = -1;
		for(int i = 0; i < a.length;){
			if(!set){
				start = i;
				set = true;
			}
			
			end = locCordinates(a, start);
			i = end + 1;
			
			a = reverse(a, start, end);
			
		}
		
		return a;
	}
			
	public static void display(int[] a){
		System.out.println("\nDisplaying the array: ");
		for(int i : a)
			System.out.print(i+" ");
	}
			
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the size of the array: ");
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter element"+i+": ");
			a[i] = Integer.parseInt(br.readLine());
		}
		
		display(a);
		a = revTrend(a);
		display(a);
		
	}
}
		