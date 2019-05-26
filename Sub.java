/*'''An array and a positive integer (k) are given as input. A subarray from the array has to be found such that the average of this
 subarray is greater than or equal to k.

For example, consider the array: arr = {-2, 1, 6, -3} and k = 3. The longest subarray is {1, 6} having average 3.5 greater than k = 3. '''*/

class Sub 
{
	static int[] cor = new int[2];
	
	public static int getAverage(int[] a, int start, int end){
		int sum = 0;
		for(int i = start; i < end; i++)
			sum += a[i];
		return sum/(end - start);
	}
	
	public static int[] subArray(int[] a, int start, int end, int k){
		int pre = 100; 
		if(start == end)
			return cor;
		if(getAverage(a, start, end) >= k && getAverage(a, start, end) < pre){
			cor[0] = start;
			cor[1] = end;
			pre = getAverage(a, start, end);
			if(getAverage(a, start, end) == k)
				return cor;
		}
		subArray(a, start, end - 1, k);
		subArray(a, start + 1, end, k);
		
		return cor;
	}
	
	public static void main(String[] args){
		int[] a = {-2, 1, 6, -3};
		int k = 3;
		
		int[] r = subArray(a, 0, a.length, 3);
		
		for(int i = r[0] - 1; i < r[1]; i++)
			System.out.print(" "+a[i]);
	}
}