/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kaustubh Joshi
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		
		try{
			list1.remove(-1);
			fail("check index out of bounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
		
		try{
			list1.remove(list1.size());
			fail("check index ");
		}catch (IndexOutOfBoundsException e) {

		}
		
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check element 1 is correct ", (Integer)42, list1.get(1));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals(list1.head.data , null);
		assertEquals(list1.head.next.data , (Integer)21);
		assertEquals(list1.head.next.prev.data , null);
		assertEquals(list1.head.next.next.data , (Integer)42);
		assertEquals(list1.head.next.next.prev.data , (Integer)21);
		
		int b = longerList.remove(longerList.size() - 1);
		assertEquals("Remove: check b is correct ", 9, b);
		assertEquals("Remove: check element 9 is correct ", (Integer)8, longerList.get(longerList.size() - 1));
		assertEquals("Remove: check element 8 is correct ", (Integer)7, longerList.get(7));
		assertEquals("Remove: check element 7 is correct ", (Integer)6, longerList.get(6));
		assertEquals("Remove: check size is correct ", 9, longerList.size());
		assertEquals(longerList.tail.data , null);
		assertEquals(longerList.tail.prev.data , (Integer)8);
		assertEquals(longerList.tail.prev.prev.data , (Integer)7);
		assertEquals(longerList.tail.prev.prev.next.data , (Integer)8);
		
		int c = longerList.remove(4);
		assertEquals("Remove: check c is correct ", 4, c);
		assertEquals("Remove: check element 4 is correct ", (Integer)3, longerList.get(3));
		assertEquals("Remove: check element 5 is correct ", (Integer)5, longerList.get(4));
		assertEquals("Remove: check size is correct ", 8, longerList.size());
		
		
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try{
			emptyList.add(null);
			fail("check null pointer exception");
		}catch(NullPointerException e){
			
		}
		
		int sizeBefore = emptyList.size();
		
		emptyList.add(100);
		
		int sizeAfter = emptyList.size();
		
		assertEquals(emptyList.get(0), (Integer) 100);
		
		assertEquals("check increment", sizeBefore + 1, sizeAfter);
		
		list1.add(100);
		
		assertEquals("check last element",(Integer)100, list1.tail.prev.data); 
		
		assertEquals("check size " , list1.get( list1.size() - 1), (Integer) 100 );
		
		
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		assertEquals(list1.size() , 3);
		assertEquals(emptyList.size(), 0);
		assertEquals(longerList.size(), 10);
		assertEquals(shortList.size(),2);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try{
			list1.add(0, null);
			fail("check null pointer");
		}catch (NullPointerException e) {

		}
		
		try{
			list1.add(-1,100);
			fail("check index out of bounds");
			
		}catch (IndexOutOfBoundsException e) {

		}
		
		try{
			list1.add(list1.size() + 1,100);
			fail("check index out of bounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
		
		
		list1.add(0,100);
		assertEquals(list1.get(0), (Integer) 100);
		
		list1.add(1,200);
		assertEquals(list1.get(1), (Integer) 200);
		
		list1.add(2,300);
		assertEquals(list1.get(2), (Integer) 300);
		
		list1.add(3,400);
		assertEquals(list1.get(3), (Integer) 400);
		
		list1.add(4,500);
		assertEquals(list1.get(4), (Integer) 500);
		
		list1.add(list1.size(),600);
		assertEquals(list1.get(list1.size() - 1), (Integer) 600);
		
		
		emptyList.add(0,100);
		assertEquals(emptyList.get(0), (Integer) 100);
		assertEquals((Integer)emptyList.size(), (Integer)1);
		
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		
		try{
			list1.set(-1, 100);
			fail("check index ");
		}catch (IndexOutOfBoundsException e) {

		}
		
		try{
			list1.set(0, null);
			fail("check null pointer ");
		}catch (NullPointerException e) {

		}
		
		
		try{
			list1.set(list1.size(), 100);
			fail("check index ");
		}catch (IndexOutOfBoundsException e) {

		}
		
		list1.set(0, 100);
		assertEquals(list1.get(0),(Integer)100);
		list1.set(1, 100);
		assertEquals(list1.get(1),(Integer)100);
		list1.set(2, 100);
		assertEquals(list1.get(2),(Integer)100);
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
