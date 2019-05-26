import java.io.*;
class StreetL
{
	public static class Dist
	{
		private int start;
		private int end;
		
		public Dist(int s, int e){
			start = s;
			end = e;
		}
		
		public int getStart(){
			return start;
		}
		
		public int getEnd(){
			return end;
		}
		
		public void setStart(int data){
			start = data;
		}
		
		public void setEnd(int data){
			end = data;
		}
		
		public int getDist(){
			return end - start;
		}
	}
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lights = Integer.parseInt(br.readLine());
		Dist[] cover = new Dist[lights];
		
		for(int i = 0; i < lights; i++)
			cover[i] = new Dist(Integer.parseInt(br.readLine()),
			Integer.parseInt(br.readLine()));
			
		Dist temp = new Dist(cover[0].getStart(), cover[0].getEnd());
		for(Dist ob: cover){
			if(temp.getStart() > ob.getStart())
				temp.setStart(ob.getStart());
			if(temp.getEnd() < ob.getEnd())
				temp.setEnd(ob.getEnd());
		}
		System.out.println("Distance: "+temp.getDist());
	}
}