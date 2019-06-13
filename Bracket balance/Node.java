public class Node 
{
	char data;
	Node next;
	
	
	Node(char data){
		this.data = data;
		this.next = null;
	}
	
	public char getData(){
		return this.data;
	}
	
	public void setData(char data){
		this.data = data;
	}
	
	public Node getNext(){
		return this.next;
	}
	
	public void setNext(Node n){
		this.next = n;
	}
	
}