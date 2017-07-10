package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<>(null);
		tail = new LLNode<>(null);
		head.next = tail;
		tail.prev = head;
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException();
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		size++;
		return true;

	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index <0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		LLNode<E> current = head.next;
		for (int i = 0; i< index; i++)
		{
			current = current.next;
		}
		
		return current.data;	

	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null)
			throw new NullPointerException();
		if (index>size || index<0 )
			throw new IndexOutOfBoundsException();
		LLNode<E> newNode = new LLNode<E>(element);
		if (index == 0)
		{
			newNode.prev = head;
			newNode.next = head.next;
			head.next.prev = newNode;
			head.next = newNode;
		} else {
			LLNode<E> current = head.next;
			for (int i = 0; i< index; i++)
			{
				current = current.next;
			}
			
			newNode.prev = current.prev;
			newNode.next = current;
			current.prev.next = newNode;
			current.prev = newNode;
		}
		
		size++;

	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index <0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		LLNode<E> current = head.next;
		for (int i = 0; i< index; i++)
		{
			current = current.next;
		}
		
		current.prev.next = current.next;
		current.next.prev = current.prev;
		size --;
		
		
		return current.data;

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
		// TODO: Implement this method
		if (index <0 || index >= size)
			throw new IndexOutOfBoundsException();
		if (element==null)
			throw new NullPointerException();
		
		LLNode<E> current = head.next;
		for (int i = 0; i< index; i++)
		{
			current = current.next;
		}
		
		E temp = current.data;
		current.data = element;
		return temp;
	}   
	public String toString()
	{
		LLNode<E> current = head.next;
		
		//System.out.println(current.data.getClass());
		
		String output = "";
		while(current.data != null)
		{
			//System.out.println(current.data.getClass().getName());
			if (current.data.getClass().getName().equals("java.lang.String"))
			{
				output += "[" + current.data + "]";
			}
			else {
				output += "[" + current.data.toString() + "]";
			}
			current = current.next;
		}
		return output;
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
