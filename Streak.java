import java.util.ArrayList;
import java.util.List;

class Streak
{
	static int N = 4;
	static int streaks;
	static int count = 0; 
	static List<Cor> taken = new ArrayList<>();
	
	static class Cor{
		int x, y, px, py;
		Cor(int x, int y, int px, int py){
			this.x = x;
			this.y = y;
			this.px = px;
			this.py = py;
		}
	}

	public static boolean isSafe(int x, int y, int px, int py){
		if(x > -1 && x < N && y > -1 && y < N) {
		
			if(taken.isEmpty())
				return true;
			
			for(Cor ob : taken)
				if(ob.x == x && ob.y == y && ob.px == px && ob.py == py)
					return false;
			
			return true;
		}
		
		return false;
	}

	public static void takenCor() {
		for(Cor ob : taken)
			System.out.println("x: "+ob.x+" y: "+ob.y);
		System.out.println("Size: "+taken.size());
	}
	
	public static void streak(int[][] s, int x, int y, int prev, int px, int py){
		if(x > N - 1 && y > N - 1) 
			return;

		if(isSafe(x, y, px, py)){
			taken.add(new Cor(x, y, px, py));
			
			if(s[x][y] == prev) 
				streaks++;
			
			streak(s, x + 1, y, s[x][y], x, y);
			streak(s, x, y + 1, s[x][y], x, y);
			streak(s, x + 1, y + 1, s[x][y], x, y);

		}
		
	}
	
	public static void main(String[] args)
	{
		int[][] s = {{1,1,1,1},
					{1,1,1,1},
					{1,1,0,0},
					{1,0,1,0}};
		
		int[][] s1 = {{1,1},
					{1,1}};
		
		int[][] s2 = {{1,1,0},
				   	  {0,1,1},
					  {1,1,1}};
					
		display(s);
		streak(s, 0, 0, -1, -1, -1);
		//takenCor();
		System.out.println("\nStreaks : "+streaks);

	}

	private static void display(int[][] s) {
		System.out.println("Displaying matrix: ");
		for(int[] i : s) {
			for(int j : i)
				System.out.print(j+" ");
			System.out.println();
		}
	}
}