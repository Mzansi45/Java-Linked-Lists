/**
 * 
 * @author Thulani
 *
 * @param <T> Generic Type for class
 * @apiNote this serves as a template for linked Nodes
 * @version One
 */
public class Node <T>{
	@SuppressWarnings("unchecked")
	private T value = (T) new Object();
	private Node<T> next = null;
	private Node<T> prev = null;
	
	/**
	 * @return the method returns the value saved in the class
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param value is the value to be saved in the class
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @return the next reference or next value
	 */
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * 
	 * @param next is for setting the next value
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	/**
	 * 
	 * @return the previous value of the Node
	 */
	public Node<T> getPrev() {
		return prev;
	}
	
	/**
	 * 
	 * @param prev setting the previous value
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	
	
}
