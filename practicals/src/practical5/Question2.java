package practical5;

import java.util.Iterator;
import java.util.Stack;

public class Question2 {
    public static void main(String[] args) {
        // Write your test here
    }
}

interface MyList<E> extends java.lang.Iterable {
    void add(E element);

    void add(int index, E element);

    boolean contains(E element);

    E get(int index);

    int indexOf(E element);

    boolean isEmpty();

    int lastIndexOf(E element);

    boolean remove(int index);

    E set(int index, E element);
}

abstract class MyAbstractList<E> implements MyList<E> {
    // HERE: declare size variable and
    // provide partial implementation
}

class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private class LinkedListIterator implements java.util.Iterator<E> {
        // HERE: implement all methods in Interator interface
    }

    private class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E value) {
            this.element = value;
            this.next = null;
        }

        public void setNext(Node<E> node) {
            this.next = node;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public E getValue() {
            return this.element;
        }
    }

    @Override
    public void add(E element) {
        if (this.head == null) {
            this.head = new Node(element);
            this.tail = this.head;
        } else {
            Node<E> newNode = new Node(element);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void add(int index, E element) {
        Node<E> newNode = new Node(element);
        if (index > this.size - 1) {
            System.out.println("Error");
        } else if (index == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else if (index == this.size - 1) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            Node<E> currentNode = this.head;
            int currentIndex = 0;
            while (currentNode != null) {
                if (currentIndex == index - 1) {
                    newNode.setNext(currentNode.getNext());
                    currentNode.setNext(newNode);

                } else {
                    currentNode = currentNode.getNext();
                }
            }
        }
        this.size++;
    }

    @Override
    public boolean contains(E element) {
        Node<E> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(element)) {
                return true;
            } else {
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        Node<E> currentNode = this.head;
        int currentIndex = 0;
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode.getValue();
            } else {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        Node<E> currentNode = this.head;
        int currentIndex = 0;
        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode.getValue();
            } else {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int lastIndexOf(E element) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean remove(int index) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E set(int index, E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}