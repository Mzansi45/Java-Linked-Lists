
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		for(int x =0;x<10;x++)
		{
			list.addToHead(x);
		}
		
		list.getTail().setValue(12);
		System.out.println(list.getTail().getValue());
		System.out.println(list.toString());
		
		System.out.println(list.getLength());
	}
}
