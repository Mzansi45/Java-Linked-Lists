
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		for(int x =0;x<10;x++)
		{
			list.addToTail(x);
		}
		
		list.getTail().setValue(12);
		System.out.println(list.getTail().getValue());
		System.out.println(list.toString());
		
		System.out.println(list.getLength());
		
		list.addBefore(30,13);
		System.out.println(list.toString());
	}
}
