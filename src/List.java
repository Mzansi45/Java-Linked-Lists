/**
 * 
 * @author Thulani
 *
 * @param <T> Generic Type for class
 * @apiNote this serves as a template for linked lists
 * @version One
 */
public class List <T>{
	@SuppressWarnings("unchecked")
	private T value = (T) new Object();
	private List<T> next = null;
	private List<T> prev = null;
	
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
	public List<T> getNext() {
		return next;
	}
	
	/**
	 * 
	 * @param next is for setting the next value
	 */
	public void setNext(List<T> next) {
		this.next = next;
	}
	
	/**
	 * 
	 * @return the previous value of the list
	 */
	public List<T> getPrev() {
		return prev;
	}
	
	/**
	 * 
	 * @param prev setting the previous value
	 */
	public void setPrev(List<T> prev) {
		this.prev = prev;
	}
	
	
}
