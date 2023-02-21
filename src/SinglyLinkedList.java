
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
		if(length==0)
		{
			length++;
			head.setValue(value);
			tail.setValue(value);
			head.setNext(tail);
			
		}else if(length ==1)
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
		
		return ret;
	}
}
