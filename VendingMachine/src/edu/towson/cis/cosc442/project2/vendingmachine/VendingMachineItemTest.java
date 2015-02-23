package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	VendingMachineItem item1, item2;
	
	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		item1 = new VendingMachineItem("Turtles", 5.00);
		item2 = new VendingMachineItem("PopTarts", 4.00);
	}
	
	/**
	 * Test that the constructor throws the exception when price provided is < 0
	 * 
	 */
	@Test(expected = VendingMachineException.class)
	public void testConstructorException(){
		new VendingMachineItem("Pope Francis", -2.0);
	}
	
	/**
	 * Tests that the correct name String is returned
	 */
	@Test
	public void testGetName(){
		assertEquals("Turtles", item1.getName());
		assertEquals("PopTarts", item2.getName());
	}
	
	/**
	 * Tests that the correct price Double is returned
	 */
	@Test
	public void testGetPrice(){
		assertEquals(5.00, item1.getPrice(), 0.001);
		assertEquals(4.00, item2.getPrice(), 0.001);
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown(){
		item1 = null;
		item2 = null;
	}
	


}
