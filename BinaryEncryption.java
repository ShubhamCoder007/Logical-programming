import java.io.*;
class BinaryEncryption
{	
	public static int binaryOnes(int n){
		int ones = 0;
		do{
			if(n % 2 != 0)
				ones++;
			n /= 2;
		}while(n > 0);
		return ones;
	}
	
	public static int callibrate(char c, int tot){
		int asc = (int)c + tot;
		return asc > 90 ? asc%90 + 65 : asc;
	}
		
	
	public static String encrypt(String s, int tot){
		String st = "";
		for(char c: s.toCharArray())
			st = st + (char)callibrate(c, tot);
		return st;
	}
	
	public static void main(String[] args)throws IOException{
		System.out.println("Enter the string: ");
		String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
		s = s.toUpperCase();
		
		int ones = 0;
		for(char c: s.toCharArray())
			ones += binaryOnes((int)c);
		
		System.out.println("Encrypted String: "+encrypt(s, ones));
	}
}
		