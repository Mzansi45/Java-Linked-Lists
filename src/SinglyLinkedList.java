/**
 * 
 * @author Thulani
 *
 * @param <T> generic type for class
 * @apiNote this class is a singly linked list. 
 */
public class SinglyLinkedList<T>{
	private List<T> head = new List<T>();
	private List<T> tail = new List<T>();
	private Integer length = 0;
	
	public List<T> getHead() {
		return head;
	}

	public void setHead(List<T> head) {
		this.head = head;
	}

	public List<T> getTail() {
		return tail;
	}

	public void setTail(List<T> tail) {
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
		//set all values to null to represent an empty list
		head.setNext(null);
		head.setPrev(null);
		head.setValue(null);
		
		tail.setNext(null);
		tail.setPrev(null);
		tail.setValue(null);
	}
	
	/**
	 * @apiNote this method adds a value from the parameter to the head of the list
	 * @param value is the value to be added to the list
	 */
	public void addToHead(T value)
	{
		//if list is empty, add same value to head and tail
		if(length==0)
		{
			length++;
			head.setValue(value);
			tail.setValue(value);
			head.setNext(tail);
			
		}else if(length ==1) // one value exists, change the head to the new value and make next value be the tail
		{
			List<T> newNode = new List<T>();
			newNode.setValue(value);
			newNode.setNext(tail);
			head = newNode;
			length++;
		}
		else
		{
			List<T> oldList = new List<T>();
			oldList = head;
			head = null;
			
			List<T> newNode = new List<T>();
			newNode.setValue(value);
			
			//head.setValue(value);
			newNode.setNext(oldList);
			head = newNode;
			length++;
		}
	}
	
	/**
	 * @apiNote this methods prints the values in the list from the head to the tail.
	 */
	public String toString() {
		
		String ret = "";
		
		boolean cont = true;
		
		List<T> temp = head;
		
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
					List<T> nextNode = temp.getNext();
					temp = nextNode;
				
				}
			}
		}
		
		return ret;
	}
	
	public void addToTail(T value)
	{
		if(length==0)
		{
			length++;
			head.setValue(value);
			tail.setValue(value);
			head.setNext(tail);
		}
		else if(length ==1)
		{
			length++;
			tail.setValue(value);
		}
		else {
			List<T> newNode = new List<T>();
			newNode.setValue(value);
			newNode.setNext(null);
			tail.setNext(newNode);
			tail = newNode;
			length++;
		}
	}
	
	public void addAfter(T value, T valueAfter)
	{
		boolean cont = true;
		
		List<T> temp = head;
		
		if(valueAfter == tail.getValue())
		{
			this.addToTail(value);
			length++;
			return;
		}
		
		SinglyLinkedList<T> list = new SinglyLinkedList<>();
		
		
		while(cont)
		{
			if(temp.getValue() == valueAfter)
			{
				List<T> newNode = new List<>();
				newNode.setValue(value);
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				list.setTail(temp);
				length++;
				return;
			}
			else
			{
				list.addToTail(temp.getValue());
				List<T> nextNode = temp.getNext();
				temp = nextNode;
			}
			
			if(temp.getNext() == null && temp.getValue()!=valueAfter ) {
				System.err.println("\"" +valueAfter+"\" is not in the list.\"" +valueAfter+"\" has been added to the tail");
				this.addToTail(value);
				cont = false;
				return;
			}
		}
	}
	
	
	public void addBefore(T value, T valueBefore)
	{
		boolean cont = true;
		
		List<T> temp = head;
		
		//if value before is the head
		if(head.getValue() == valueBefore)
		{
			this.addToHead(value);
			length++;
			return;
		}
		
		int count = 0;
		
		SinglyLinkedList<T> newList = new SinglyLinkedList<>();
		
		while(cont)
		{	
			count++;
			if(count>=length)
			{
				System.err.println("\"" +valueBefore+"\" is not in the list.\"" +valueBefore+"\" has been added to the tail");
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
				List<T> nextNode = temp.getNext();
				temp = nextNode;
			}
			else
			{
				List<T> newNode = new List<>();
				newNode.setValue(value);
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				newList.setTail(newNode);	
				return;
			}
			
		}
	}
}
