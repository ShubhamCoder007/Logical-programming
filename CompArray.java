/*Given an array arr[] of n integers, construct a Sum Array sum[] (of same size) 
such that sum[i] is equal to the sum of all the elements of arr[] except arr[i]. 
Solve it without subtraction operator and in O(n).*/

class CompArray
{
	public static int totalSum(int[] a){
		int sum = 0;
		for(int i : a)
			sum += i;
		return sum;
	}
	
	public static int[] getCompArray(int[] a){
		int total = totalSum(a);
		int[] output = new int[a.length];
		for(int i = 0; i < a.length; i++)
			output[i] = total - a[i];
		return output;
	}
	
	public static void main(String[] args)
	{
		int[] a = {3, 6, 4, 8, 9};
		
		System.out.println("Complementary array: ");
		for(int i : getCompArray(a))
			System.out.print(i+" ");
	}
}