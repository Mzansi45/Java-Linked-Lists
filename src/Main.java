
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		for(int x =0;x<10;x++)
		{
			list.addToTail(x);
		}
		
		System.out.println(list.toString());
		
		list.deleteNode(7);
		System.out.println(list.toString());
		System.out.println("Size - " + list.getLength());
	}
}
