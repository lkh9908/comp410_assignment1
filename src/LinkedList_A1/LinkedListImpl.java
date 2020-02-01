/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  @Override
  public boolean insert(double elt, int index) {
//		insert
//	    in: a double (the data element), and an int (position index)
//	    return: boolean, return true if insert is successful, false otherwise
//	    effect: the list state will be altered so that the element is located at the
//	            specified index; the list has size bigger by one; all elements that were
//	            at the specified index or after have been moved down one slot
//	    error: if index is beyond list size range return false
//	           valid inserts take place either at a location where a list element
//	           already exists, or at the location that is one beyond the last element
	  
	  // be the first element
	  
	  if (index < 0) {
		  return false;
	  }
	  if (this.size() == 0) {
		  if (index == 0) {
			  Node newOne = new Node(elt);
			  newOne.next = sentinel;
			  newOne.prev = sentinel;
			  sentinel.next = newOne;
			  sentinel.prev = newOne;
			  return true;
		  } else {
			  return false;
		  }
	  } else {
		  Node current = sentinel;
		  for (int i = -1; i < index-1; i++) {
			  if (current.next != sentinel) {
				  current = current.next;
			  } else {
				  return false;
			  }
		  }
		  Node newOne = new Node(elt);
		  current.next.prev = newOne;
		  newOne.next = current.next;
		  current.next = newOne;
		  newOne.prev = current;
		  return true;
	  }
  }

  @Override
  public boolean remove(int index) {
//	  	remove
//	    in: an int (the index of the element to take out of the list)
//	    return: boolean.. return true if the remove is successful, false otherwise
//	    effect: list state is altered in that the Node at the specified index is decoupled
//	            list size decreases by one
//	    errors: what if specified index is not in the list? return false
	  //empty
	  if (sentinel.next == null || index < 0) {
		  return false;
	  } else {
		  Node current = sentinel;
		  for (int i = -1; i < index; i++) {
			  if (current.next != sentinel) {
				  current = current.next;
			  } else {
				  return false;
			  }
		  }
		  current.next.prev = current.prev;
		  current.prev.next = current.next;
		  current.next = null;
		  current.prev = null;
		  return true;
	  }
  }

  @Override
  public double get(int index) {
//	  	get
//	    in: an int, the index of the element item to return
//	    return: double, the element stored at index, or Double.NaN
//	    effect: no change in state of the list
//	    error: what if index is not in the list? return Double.NaN
	  //empty
	  if (sentinel.next == null || sentinel.next == sentinel || index < 0) {
		  return Double.NaN;
	  } else {
		  Node current = sentinel;
		  for (int i = -1; i < index; i++) {
			  if (current.next != sentinel) {
				  current = current.next;
			  } else {
				  return Double.NaN;
			  }
		  }
		  return current.data;
	  }
  }

  @Override
  public int size() {
//	  size:
//	  in: nothing
//	  return: number of elements stored in the list
//	  effect: no change to list state
	  
	  Node current = sentinel;
	  int size = 0;
	  if (current.next == null || current.next == sentinel) {
		  return size;
	  } else {
		  while(current.next != sentinel) {
			  size++;
			  current = current.next;
		  }
	  }
	  return size;
  }

  @Override
  public boolean isEmpty() {
//	   isEmpty:
//	   in: nothing
//	   return: boolean, true if the list has no elements in it, true if size is 0
//	   effect: no change to list state
	if (this.size() == 0) {
		return true;
	} else {
		return false;
	}
  }

  @Override
  public void clear() {
//	  clear:
//		    in: nothing
//		    return: void
//		    effect: list is left with size 0, no elements in it,
//		            consists of just the original root Node
	  
//	  Node current = sentinel;
	  if (this.size() != 0) {
//		  do {
//			  current.prev = sentinel;
//			  current = current.next;
//		  } while(current.next != sentinel);
		  
		  sentinel.next.prev = null;
		  sentinel.prev.next = null;
		  sentinel.prev = sentinel;
		  sentinel.next = sentinel;
	  }
  }
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }


}