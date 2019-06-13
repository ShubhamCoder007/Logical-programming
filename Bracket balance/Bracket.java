import java.io.*;
class Bracket
{
	static Stack s = new Stack();
	
	public static void main(String[] args)throws IOException
	{
		System.out.println("Enter the brackets: ");
		String b = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		for(char c: b.toCharArray()){
			if(s.isEmpty()){
				s.push(c);
				continue;
			}
		
			if((s.peek() == '(' && c == ')') || (s.peek() == '{' && c == '}') || (s.peek() == '[' && c == ']')){
				s.pop();
				continue;
			}
			
			s.push(c);
		}
		
		if(!s.isEmpty())
			System.out.println("Not balanced");
		else
			System.out.println("Balanced");
		
	}
}
		
				
		