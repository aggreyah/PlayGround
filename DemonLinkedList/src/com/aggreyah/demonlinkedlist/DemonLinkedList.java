package com.aggreyah.demonlinkedlist;

class DemonLinkedList<E>{
    private LLNode <E> head;
    private LLNode <E> tail;
    private int size;

    public DemonLinkedList() {
		LLNode<E> headSentinel = new LLNode<E>();
		LLNode<E> tailSentinel = new LLNode<E>();
		this.head = headSentinel;
		this.tail = tailSentinel;
		headSentinel.next = tailSentinel;
		tailSentinel.prev = headSentinel;
		this.size = 0;
    }
    
    /**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> currentNode = new LLNode <E>(element);
		currentNode.prev = this.tail.prev;
		this.tail.prev = currentNode;
		currentNode.prev.next = currentNode;
		currentNode.next = this.tail;
		this.size += 1;
		return (this.size > 0);
    }
    
    /** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index > this.size - 1 || index < 0)
			throw new IndexOutOfBoundsException("You are attempting to access from an out of bounds index, Sorry!");
		LLNode <E> newNode = this.head;
		if (newNode.next == this.tail)
			System.out.println("An empty list.");
		int i = 0;
		while (i <= index && newNode.next != this.tail) {
			newNode = newNode.next;
			i++;
		}
		return newNode.data;
	}
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
	}
	
//	/** Return the size of the list */
//	public int size() 
//	{
//		// TODO: Implement this method
//		
//		return this.size;
//	}
//
//	/** Remove a node at the specified index and return its data element.
//	 * @param index The index of the element to remove
//	 * @return The data element removed
//	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
//	 * 
//	 */
//	public E remove(int index) 
//	{
//		// TODO: Implement this method
//		return null;
//	}
//
//	/**
//	 * Set an index position in the list to a new element
//	 * @param index The index of the element to change
//	 * @param element The new element
//	 * @return The element that was replaced
//	 * @throws IndexOutOfBoundsException if the index is out of bounds.
//	 */
//	public E set(int index, E element) 
//	{
//		// TODO: Implement this method
//		return null;
//	}
    public static void main(String [] args) {
        System.out.println("Hello World of Linked Lists!");
        DemonLinkedList<String> myStringLinkedList = new DemonLinkedList<String>();
        DemonLinkedList<Integer> myIntLinkedList = new DemonLinkedList<Integer>();
        System.out.println("Size: " + myStringLinkedList.size);
        myStringLinkedList.add("Aggrey Ochieng");
        myStringLinkedList.add("Jeff Dean");
        myStringLinkedList.add("Sanjay Gamawat");
        System.out.println("Size: " + myStringLinkedList.size);
        System.out.println("Last: " + myStringLinkedList.tail.prev.data);
        System.out.println("First: " + myStringLinkedList.head.next.data);
        System.out.println("Second: " + myStringLinkedList.head.next.next.data);
        System.out.println("At index 0: " + myStringLinkedList.get(0));
        System.out.println("At index 1: " + myStringLinkedList.get(1));
        System.out.println("At index 2: " + myStringLinkedList.get(2));
    }
}
class LLNode <E> {
    LLNode <E> next;
    E data;
    LLNode <E> prev;

    LLNode(){
        this.next = null;
        this.data = null;
        this.prev = null;
    }

    LLNode(E e){
        this.next = null;
        this.data = e;
        this.prev = null;
    }
}