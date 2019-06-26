import java.io.*;
class DecodeString
{
	static Stack stack = new Stack();
	static boolean numFlag = false;
	
	
	public static boolean isNumber(char c){
		return (int)c >= 48 && (int)c <= 57 ? true : false;
	}
	
	public static boolean isChar(char c){
		return (int)c >= 65 && (int)c <= 90 || (int)c >= 97 && (int)c <= 122 ? true : false;
	}
	
	public static String multiply(String s, int num){
		System.out.println("mul num: "+num);
		String st = "";
		while(num > 0){
			st = st + s;
			num--;
		}
		return st;
	}
		
	
	public static String resultantExpand(String s){
		String r = "";
		int end = -1;
		int start = -1;
		
		for(int i = s.length() - 1; i >= 0; i--){
			if(isNumber(s.charAt(i))){
				System.out.println("num sec"+s.charAt(i));
				if(end == -1){
					end = start = i;
					continue;
				}
				start = i;
			}
			
			if(start != -1){
				if(start != end)
					r = multiply(r, Integer.parseInt(s.substring(start, end + 1)));
				else
					r = multiply(r, Integer.parseInt(Character.toString(s.charAt(end))));
				start = end = -1;
				continue;
			}
			
			r = s.charAt(i) + r;
		}
		
		return r;
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
				
				while(!stack.isEmpty() && isChar(stack.peek())){
					System.out.println("1"+dec);
					dec = stack.pop() + dec;
				}
				
				continue;
					
			}
			
			stack.push(c);
		}
		
		while(!stack.isEmpty())
			dec = stack.pop() + dec;
		
		dec = resultantExpand(dec);
		
		System.out.println("Decrypted string: "+dec);
		
	}
}
					
		
					