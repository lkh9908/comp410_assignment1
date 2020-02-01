package LinkedList_A1;

public class LinkedListPlayground {

	public static void main(String[] args) { 
		/*
     here you can instantiate your LinkedList and play around with it to check
     correctness. We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. This is for your use in testing your implementation.
		 */
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
		test6();

	}

	public static void test1(){
		// example test cases
		System.out.println("TEST1");
		LinkedListImpl L= new LinkedListImpl();
		System.out.println(L.isEmpty());
		printList(L);
		L.clear();
		System.out.println(L.isEmpty());
		printList(L);
		System.out.println("length is " + L.size());
		System.out.println(L.sentinel.toString());
		System.out.println("------------------------");

		L.insert(3.3,0);
		System.out.println(L.isEmpty());
		printList(L);
		System.out.println(L.sentinel.next.toString());
		System.out.println("length is " + L.size());
		System.out.println("------------------------");

		System.out.println(L.insert(3.4, 0));
		L.insert(3.5, 0);
		L.insert(3.67, 1);
		L.insert(3.357, 0);
		L.insert(3.333, 4);
		System.out.println("length is " + L.size());
		printList(L);
		System.out.println("------------------------");

		L.remove(3);
		System.out.println("length is " + L.size());
		printList(L);
		System.out.println("------------------------");

		L.clear();
		printList(L);
		System.out.println(L.sentinel.next);
		System.out.println("length is " + L.size());
		System.out.println(L.insert(3.4, 0));
		L.insert(3.5, 0);
		L.insert(3.67, 1);
		L.insert(3.357, 0);
		L.insert(3.333, 3);
		System.out.println("length is " + L.size());
		printList(L);
		L.remove(0);
		System.out.println("length is " + L.size());
		printList(L);
		System.out.println("------------------------");
	}

	public static void test2(){
		// example test cases
		System.out.println("TEST2");
		LinkedListImpl L= new LinkedListImpl();
		L.insert(3.4,0);
		L.insert(3.5,1);
		L.insert(3.67,2);
		printList(L);
		L.remove(0);
		System.out.println("length is " + L.size());
		printList(L);
		System.out.println("------------------------");
	}

	public static void test3(){
		// example test cases
		System.out.println("TEST3");
		LinkedListImpl L= new LinkedListImpl();
		L.insert(3,0);
		L.insert(5,1);
		printList(L);
		System.out.println("element at 0 is " + L.get(0));
		System.out.println("------------------------");
	}
	
	public static void test4(){
		// example test cases
		System.out.println("TEST4");
		LinkedListImpl L= new LinkedListImpl();
		L.insert(3,0);
		printList(L);
		L.insert(2.0,1);
		L.insert(1.0,2);
		L.remove(0);
		printList(L);
		System.out.println("------------------------");
		
		L.clear();
		L.insert(3,0);
		L.insert(2.0,1);
		L.insert(1,0);
		L.remove(2);
		System.out.println("length is " + L.size());
		printList(L);
		System.out.println("element at 1 is " + L.get(1));
		System.out.println("------------------------");
		System.out.println("------------------------");
		System.out.println("------------------------");
	}
	
	public static void test5(){
		// example test cases
		System.out.println("TEST5 EDGE CASES");
		LinkedListImpl L= new LinkedListImpl();
		System.out.println("isEmpty is " + L.isEmpty());
		System.out.println(L.insert(3.4, 5));
		System.out.println(L.insert(3.4, 100));
		System.out.println(L.insert(3.4, -1));
		System.out.println(L.remove(2));
		System.out.println(L.remove(-2));
		for (int i = 0; i < 50; i++) {
			L.insert(i, 0);
		}
		printList(L);
		System.out.println("the element before sentinel is " + L.sentinel.prev);
		System.out.println("element at 49 is " + L.get(49));
		for (int i = 0; i < 50; i++) {
			L.remove(49-i);
		}
		printList(L);
		System.out.println("------------------------");
		
		L.clear();
		Node current = L.sentinel;
		for (int i = 0; i < 10; i++) {
			L.insert(i, L.size());
		}
		printList(L);
		for (int i = 0; i < 10; i++) {
			System.out.println(current.prev);
			current = current.prev;
		}
		System.out.println("------------------------");
		
		L.clear();
		L.insert(1, 0);
		L.insert(1, 0);
		L.insert(1, 0);
		for (int i = 0; i < 10; i++) {
			L.insert(22, 3);
		}
		printList(L);
		for (int i = 0; i < 20; i++) {
			System.out.println("element at " + i + " is " + L.get(i));
		}
		System.out.println("element at 100 is " + L.get(100));
		System.out.println("------------------------");
		
		L.clear();
		L.insert(1, 0);
		L.insert(1, 0);
		L.insert(1, 0);
		printList(L);
		System.out.println("element at -1 is " + L.get(-1));
		System.out.println("element at -2 is " + L.get(-2));
		System.out.println(L.insert(3.4, -3));
		printList(L);
		System.out.println("length is " + L.size());
		System.out.println(L.remove(-1));
		System.out.println("isEmpty is " + L.isEmpty());
		printList(L);
		System.out.println("length is " + L.size());
		L.clear();
		System.out.println("isEmpty is " + L.isEmpty());
		System.out.println("length is " + L.size());
	}
	
	public static void test6(){
		// example test cases
		System.out.println("TEST6 EDGE CASES 2");
		LinkedListImpl L= new LinkedListImpl();
		for (int i = 0; i < 10; i++) {
			L.insert(i, L.size());
		}
		printList(L);
		for (int i = 0; i < 10; i++) {
			System.out.println("element at " + i + " is " + L.get(i));
		}
		
		for (int i = 0; i < 10; i++) {
			L.remove(L.size()-1);
		}
		printList(L);
		for (int i = 0; i < 10; i++) {
			System.out.println("element at " + i + " is " + L.get(i));
		}
		System.out.println("isEmpty is " + L.isEmpty());
		System.out.println("------------------------");
		
		L.clear();
		for (int i = 0; i < 10; i++) {
			L.insert(i, L.size());
		}
		System.out.println("length is " + L.size());
		for (int i = 0; i < 9; i++) {
			L.remove(0);
		}
		printList(L);
		for (int i = 0; i < 10; i++) {
			System.out.println("element at " + i + " is " + L.get(i));
		}
		System.out.println("isEmpty is " + L.isEmpty());
		System.out.println("length is " + L.size());
		System.out.println("------------------------");
		
		L.clear();
		for (int i = 0; i < 10; i++) {
			L.insert(i, L.size());
		}
		System.out.println("length is " + L.size());
		for (int i = 0; i < 5; i++) {
			L.remove(5);
		}
		printList(L);
		for (int i = 0; i < 10; i++) {
			System.out.println("element at " + i + " is " + L.get(i));
		}
		System.out.println("isEmpty is " + L.isEmpty());
		System.out.println("length is " + L.size());
		System.out.println("------------------------");
	}
	

	public static void printList(LinkedListImpl L){ 
		//note that this is a good example of how to iterate through your linked list
		// since we know how many elements are in the list we can use a for loop
		// and not worry about checking the next field to see if we hit the end sentinel
		Node curr=L.sentinel.next; // the first data node in the list is the one after sentinel. 
		System.out.print("sentinel");
		for(int i=0; i<L.size(); i++) { 
			System.out.print(" --> " + curr.data);
			curr=curr.next;
		}

		System.out.println();
	}
}