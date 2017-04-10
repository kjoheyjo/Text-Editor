package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author Kaustubh Joshi
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {

		this.size = 0;
		
		this.head = new LLNode<E>(null);
		head.prev = null;
		
		this.tail = new LLNode<E>(null);
		tail.next = null;
		
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException();
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		
		if(this.size == 0){
			head.next = newNode;
			newNode.prev = head;
			
			newNode.next = tail;
			tail.prev = newNode; 
			
			this.size =  1;
			return true;
		}else{
			
			tail.prev.next = newNode;
			newNode.next = tail;
			
			newNode.prev = tail.prev;
			tail.prev = newNode;
			
			size++;
			return true;
		}
		
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		LLNode<E> temp = head;
		int ind = 0;
		
		if(size == 0 || index < 0){
			throw new IndexOutOfBoundsException();
		}
		
		for(int i = 0 ; i <= index ; i++){
			
			temp = temp.next;
			
			if(temp == tail){
				throw new IndexOutOfBoundsException();
			}
			
		}
		
		return temp.data ;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if(element == null){
			throw new NullPointerException();
		}
		
		if(index < 0){
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		
		if(index == 0){
			
			newNode.next = head.next;
			head.next.prev = newNode;
			
			head.next = newNode;
			newNode.prev = head;
			
			size++;
			
			return;
			
		}
		
		LLNode<E> temp = head;
		
		for(int i = 0; i < index; i++){
			
			temp = temp.next;
			
			if(temp == null || temp == tail){
				throw new IndexOutOfBoundsException();
			}
			
			
		}
		
		newNode.next = temp.next;
		temp.next.prev = newNode;
		
		temp.next = newNode;
		newNode.prev = temp;
		
		size++;
		
		
		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		
		if(index < 0 || index >= this.size ){
			throw new IndexOutOfBoundsException();
		}
		
		if(index == 0){
			LLNode<E> first = head.next;
			
			first.next.prev = head;
			
			head.next = first.next;
			
			size--;
			
			return first.data;
			
		}
		
		LLNode<E> temp = head;
		
		for(int i = 0 ; i <= index; i++){
			temp = temp.next;
			
		}
		
		temp.prev.next = temp.next;
		
		temp.next.prev = temp.prev;
		
		size--;
		
		return temp.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		int ind = 0;
		
		if(size == 0 || index < 0  || index >= size ){
			throw new IndexOutOfBoundsException();
		}
		
		if(element == null){
			throw new NullPointerException();
		}
		
		LLNode<E> temp = head;
		
		for(int i = 0 ; i <= index ; i++){
			
			temp = temp.next;
			
		}
		
		E data = temp.data;
		
		temp.data = element;
		
		return data;
		
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
