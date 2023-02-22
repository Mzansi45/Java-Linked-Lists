

/**
 * 
 * @author Thulani
 *
 * @param <T> generic type for class
 * @apiNote this class is a singly linked Node. 
 */
public class SinglyLinkedList<T>{
	private Node<T> head = new Node<T>();
	private Node<T> tail = new Node<T>();
	private Integer length = 0;
	
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public SinglyLinkedList()
	{
		//set all values to null to represent an empty Node
		head.setNext(null);
		head.setPrev(null);
		head.setValue(null);
		
		tail.setNext(null);
		tail.setPrev(null);
		tail.setValue(null);
	}
	
	/**
	 * @apiNote this method deletes a node specified in the parameter
	 * @param value item you want to delete in the list
	 */
	public void deleteNode(T value)
	{
		
		SinglyLinkedList<T> list = new SinglyLinkedList<>();
		
		Node<T> temp = head;
		
		while(temp !=null)
		{
			if(value != temp.getValue())
			{
				list.addToTail(temp.getValue());
			}
			
			Node<T> newNode = temp.getNext();
			temp = newNode;
		}
		
		this.head = list.head;
		this.tail = list.tail;
		length--;
	}
	
	@SuppressWarnings("unchecked")
	public T[] convertToArray() {
		
		T[] array = (T[]) new Object[length];
		
		Node<T> temp = head;
		
		int count = 0;
		
		while(temp != null)
		{
			array[count] = temp.getValue();
			Node<T> newNode = new Node<>();
			newNode = temp.getNext();
			temp = newNode;
			count++;
		}
		
		return array;
	}
	
	/**
	 * @apiNote this method adds a value from the parameter to the head of the Node
	 * @param value is the value to be added to the Node
	 */
	public void addToHead(T value)
	{
		//if Node is empty, add same value to head and tail
		if(length==0)
		{
			length++;
			head.setValue(value);
			tail.setValue(value);
			head.setNext(tail);
			
		}else if(length ==1) // one value exists, change the head to the new value and make next value be the tail
		{
			Node<T> newNode = new Node<T>();
			newNode.setValue(value);
			newNode.setNext(tail);
			head = newNode;
			length++;
		}
		else
		{
			Node<T> oldNode = new Node<T>();
			oldNode = head;
			head = null;
			
			Node<T> newNode = new Node<T>();
			newNode.setValue(value);
			
			//head.setValue(value);
			newNode.setNext(oldNode);
			head = newNode;
			length++;
		}
	}
	
	/**
	 * @apiNote this methods prints the values in the Node from the head to the tail.
	 */
	public String toString() {
		
		String ret = "";
		
		boolean cont = true;
		
		Node<T> temp = head;
		
		while(cont)
		{
			if(length <=1)
			{
				ret += temp.getValue();
				cont = false;
			}
			else
			{
				if(temp.getNext() == null)
				{
					ret += temp.getValue() +" ";
					cont = false;
					break;
				}else
				{
					ret += temp.getValue() +" ";
					Node<T> nextNode = temp.getNext();
					temp = nextNode;
				
				}
			}
		}
		
		return ret;
	}
	
	/**
	 * @param value to be added to the tail of the Node
	 */
	public void addToTail(T value)
	{
		//if Node is empty, add item by creating a new Node
		if(length==0)
		{
			length++;
			head.setValue(value);
			tail.setValue(value);
			head.setNext(tail);
		}
		else if(length ==1) // if Node has 1 item change the value of the tail
		{
			length++;
			tail.setValue(value);
		}
		else {
			//adding new Node item to the tail by making tail point to new items
			Node<T> newNode = new Node<T>();
			newNode.setValue(value);
			newNode.setNext(null);
			tail.setNext(newNode);
			tail = newNode;
			length++;
		}
	}
	
	/**
	 * @apiNote
	 * @param value
	 * @param valueAfter
	 */
	public void addAfter(T value, T valueAfter)
	{
		boolean cont = true;
		
		Node<T> temp = head;
		
		if(valueAfter == tail.getValue())
		{
			this.addToTail(value);
			length++;
			return;
		}
		
		SinglyLinkedList<T> Node = new SinglyLinkedList<>();
		
		
		while(cont)
		{
			if(temp.getValue() == valueAfter)
			{
				Node<T> newNode = new Node<>();
				newNode.setValue(value);
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				Node.setTail(temp);
				length++;
				return;
			}
			else
			{
				Node.addToTail(temp.getValue());
				Node<T> nextNode = temp.getNext();
				temp = nextNode;
			}
			
			if(temp.getNext() == null && temp.getValue()!=valueAfter ) {
				System.err.println("\"" +valueAfter+"\" is not in the Node.\"" +valueAfter+"\" has been added to the tail");
				this.addToTail(value);
				cont = false;
				return;
			}
		}
	}
	
	/**
	 * @apiNote this function add a before the value specified in the parameters
	 * @param value the value to be added to the Node
	 * @param valueBefore the value to add the value before
	 */
	public void addBefore(T value, T valueBefore)
	{
		boolean cont = true;
		
		Node<T> temp = head;
		
		//if value before is the head
		if(head.getValue() == valueBefore)
		{
			this.addToHead(value); //adding to the beginning of the Node
			length++;
			return;
		}
		
		int count = 0;
		
		//create a temporary Node to store values
		SinglyLinkedList<T> newList = new SinglyLinkedList<>();
		
		while(cont)
		{	
			count++;
			if(count>=length)
			{
				System.err.println("\"" +valueBefore+"\" is not in the Node.\"" +valueBefore+"\" has been added to the tail");
				this.addToTail(value);
				cont = false;
			}
			
			
			if(temp.getNext() == null)
			{
				cont = false;
			}
			
			if(temp.getNext().getValue() != valueBefore)
			{
				newList.addToTail(temp.getValue());
				Node<T> nextNode = temp.getNext();
				temp = nextNode;
			}
			else
			{
				Node<T> newNode = new Node<>();
				newNode.setValue(value);
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				newList.setTail(newNode);	
				return;
			}
		}
	}
}
