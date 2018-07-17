import java.util.Arrays;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}

/**
 * NOTE: According to Mr. Wong, the quesetion actually wants us to implements
 * a data structure that only stores unique elements.
 * 
 * So, the questions actually wants to implement Set 
 *  (but we will use the name MyList instead)
 * */
interface MyList<T> extends java.lang.Iterable<T> {
	/** Adds the elements in otherList to this list.
	* Returns true if this list changed as a result of the call */
	public boolean addAll(MyList<T> otherList);

	/** Removes all the elements in otherList from this list.
	* Returns true if this list changed as a result of the call */
	public boolean removeAll(MyList<T> otherList);

	/** Retains the elements in this list that are also in otherList.
	* Returns true if this list changed as a result of the call */
	public boolean retainAll(MyList<T> otherList);

}

abstract class MyAbstractList<T> implements MyList<T> { /*empty body*/ }

class MyArrayList<T extends Comparable<T>> extends MyAbstractList<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements = new Object[DEFAULT_CAPACITY];
	
	private void tuneCapacity() {
		if(this.elements.length == DEFAULT_CAPACITY) {
			  this.elements = Arrays.copyOf(elements, DEFAULT_CAPACITY * 2);
		} else {
			// no need to do anything
		}
	}
	
	@Override
	public boolean addAll(MyList<T> otherList) {
		boolean result = false;
		Iterator<T> it = otherList.iterator();
		while(it.hasNext()) {
			T value = it.next();
			if(this.contains(value)) {
				this.add(value);
				result = true;
			}
		}
		return result;
	}

	private void add(T value) {
		this.tuneCapacity();
		int nextIndex = this.elements.length;
		this.elements[nextIndex] = value;
	}

	private boolean contains(T value) {
		for(int i = 0; i < this.elements.length; i++) {
			if(((Comparable)this.elements[i]).compareTo(value) == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(MyList<T> otherList) {
		Iterator<T> it = otherList.iterator();
		while(it.hasNext()) {
			T value = it.next();
			if(this.contains(value)) {
				this.remove(value);
			}
		}
		return false;
	}

	private void remove(T value) {
		for(int i = 0; i < this.elements.length; i++) {
			
		}
	}

	@Override
	public boolean retainAll(MyList<T> otherList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}


