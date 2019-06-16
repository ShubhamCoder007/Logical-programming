public class Node 
{
	private char data;
	private Node next;
	
	Node(){
		this(null);
	}
	
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
