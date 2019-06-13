class Stack
{
	Node top = null;
	
	public void push(char data){
		Node n = new Node(data);
		n.setNext(top);
		top = n;
	}
	
	public char pop(){
		char data = top.getData();
		top = top.getNext();
		return data;
	}
	
	public char peek(){
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
}
