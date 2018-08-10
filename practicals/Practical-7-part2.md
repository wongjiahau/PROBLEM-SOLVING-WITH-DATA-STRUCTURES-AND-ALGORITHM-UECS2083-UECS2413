## Practical 7 Part 2
The following implementation is recursive, which is shorter and different from the lecture slides.

But is not 100% completed yet. 


```java
// Practical 7
import java.util.Iterator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		BinaryTree<Integer> myTree = new BinaryTree<Integer>(3);
		myTree.insert(1);
		myTree.insert(2);
		myTree.insert(4);
		myTree.insert(5);
		
		System.out.println("Post order");
		myTree.postorder(); 
		
		System.out.println("\nPre order");
		myTree.preorder();
		
		System.out.println("\nIn order");
		myTree.inorder();
		
		System.out.println(myTree.search(5)); // true
		System.out.println(myTree.search(6)); // false
	}
}

// Question 1
interface Tree<T> extends Iterable<T> {
	boolean search(T element);
	boolean insert(T element);
	boolean delete(T element);
	
	void inorder();
	void preorder();
	void postorder();
	int getSize();
	boolean isEmpty();
	Iterator iterator();
	void clear();
}

// Question 2
abstract class AbstractTree<T> implements Tree<T> {
	
}

// Question 3
class BinaryTree<T extends Comparable<T>> extends AbstractTree<T> {
	protected T element;
	protected BinaryTree<T> left;
	protected BinaryTree<T> right;
	public BinaryTree(T element) {
		this.element = element;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public boolean search(T element) {
		if(this.element == null) {
			return false;
		} else {
			int comparison = element.compareTo(this.element);
			if(comparison == 0) {
				return true;
			} else if(comparison > 0) {
				if(this.right == null) {
					return false;
				} else {
					return this.right.search(element);
				}
			} else /*if(comparison < 0)*/{
				if(this.left == null) {
					return false;
				} else {
					return this.left.search(element);
				}
			}
		}
	}

	@Override
	public boolean insert(T element) {
		if(this.element == null) {
			this.element = element;
			return true;
		} else {
			int comparison = element.compareTo(this.element);
			if(comparison < 0) {
				if(this.left == null) {
					this.left = new BinaryTree<T>(null);
				}
				return this.left.insert(element);
			} else if(comparison > 0) {
				if(this.right == null) {
					this.right = new BinaryTree<T>(null);
				}
				return this.right.insert(element);
			} else /*(comparison == 0)*/ {
				// Don't insert duplicated element
				return false; // Return false means fail to insert
			}
		}
	}

	@Override
	public boolean delete(T element) {
		/**
		 * In deletion there is 3 case:
		 * 1) Delete a leaf (a node without children)
		 * 2) Deleting a node with 1 child
		 * 3) Deleting a node with 2 children
		 * 
		 * So, we need to handle all these cases separately
		 * */
		
		// Before deleting, we need to locate the element first
		// Basically, the code below is same as searching, with some modification
		if(this.element == null) {
			return false;
		} else {
			int comparison = element.compareTo(this.element);
			if(comparison == 0) {
				if(this.childCount() == 0) {
					/**
					 * Haven't completed
					 * */
				}
				return true;
			} else if(comparison > 0) {
				if(this.right == null) {
					return false;
				} else {
					return this.right.delete(element);
				}
			} else /*if(comparison < 0)*/{
				if(this.left == null) {
					return false;
				} else {
					return this.left.delete(element);
				} 
			}
		}		
	}
	
	public int childCount() {
		if(this.element == null) {
			return 0;
		} else if(this.left == null && this.right == null)  {
			return 0;
		} else if(this.left != null && this.right == null)  {
			return 1;
		} else if(this.left == null && this.right != null)  {
			return 1;
		} else /* if(this.left != null && this.right != null) */ {
			return 2;
		}
		
	}
	@Override
	public void inorder() {
		/**
		 * Inorder means LEFT -> CENTER -> RIGHT
		 * */
		
		// Show left first
		if(this.left != null) {
			this.left.inorder();
		}
	
		// Show center
		if(this.element != null) {
			System.out.println(this.element);
		}
		
		// Show right
		if(this.right != null) {
			this.right.inorder();
		}
	}

	@Override
	public void preorder() {
		/**
		 * Preorder means CENTER -> LEFT -> RIGHT
		 * */
		// Show center first
		if(this.element != null) {
			System.out.println(this.element);
		}
		
		// Show left 
		if(this.left != null) {
			this.left.preorder();
		}
	
		// Show right
		if(this.right != null) {
			this.right.preorder();
		}
	}

	@Override
	public void postorder() {
		/**
		 * Postorder means LEFT -> RIGHT -> CENTER
		 * */
		// Show LEFT first
		if(this.left != null) {
			this.left.postorder();
		}
		
		
		// Show RIGHT
		if(this.right != null) {
			this.right.postorder();
		}
		
		// Show center
		if(this.element != null) {
			System.out.println(this.element);
		}
	
	}

	@Override
	public int getSize() {
		if(this.element == null) {
			return 0;
		} else {
			return 1 + this.left.getSize() + this.right.getSize();
		}
	}

	@Override
	public boolean isEmpty() {
		if(this.element == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
```