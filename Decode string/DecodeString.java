import java.io.*;
class DecodeString
{
	static Stack stack = new Stack();
	static boolean numFlag = false;
	
	
	public static boolean isNumber(char c){
		return (int)c >= 48 && (int)c <= 57 ? true : false;
	}
	
	
	public static String multiply(String s, int num){
		String st = "";
		while(num > 0){
			st = st + s;
			num--;
		}
		return st;
	}
		
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter the string: ");
		String s = br.readLine();
		
		String dec = "";
		String n = "";
		int num = 0;
		
		for(char c : s.toCharArray()){
			if(stack.isEmpty()){
				stack.push(c);
				continue;
			}
			
			if(c == ']'){
				while(stack.peek() != '[' && !stack.isEmpty()){
					dec = stack.pop() + dec;
				}
				
				if(stack.peek() == '[')
					stack.pop();
		
				while(!stack.isEmpty() && isNumber(stack.peek())){
					n = stack.pop() + n;
					numFlag = true;
				}
				
				if(numFlag){
					num = Integer.parseInt(n);
					n = "";
					
					dec = multiply(dec, num);
					
					numFlag = false;
				}
				
				continue;
					
			}
			
			stack.push(c);
		}
		
		System.out.println("Decrypted string: "+dec);
		
	}
}
					
		
					