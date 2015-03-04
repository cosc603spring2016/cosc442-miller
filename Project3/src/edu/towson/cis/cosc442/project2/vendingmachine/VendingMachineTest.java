package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine machine, machine2;
	VendingMachineItem item1, item2;
	

	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		machine = new VendingMachine();
		item1 = new VendingMachineItem("Turtles", 5.00);
		item2 = new VendingMachineItem("PopTarts", 4.00);
	}
	
	/**
	 * Tests that item slot A can be retrieved
	 */
	@Test
	public void testGetSlotIndexA() throws VendingMachineException {
		assertEquals(null, machine.getItem(VendingMachine.A_CODE));
	}
	
	/**
	 * Tests that item slot B can be retrieved
	 */
	@Test
	public void testGetSlotIndexB() throws VendingMachineException {
		assertEquals(null, machine.getItem(VendingMachine.B_CODE));
	}
	
	/**
	 * Tests that item slot C can be retrieved
	 */
	@Test
	public void testGetSlotIndexC() throws VendingMachineException {
		assertEquals(null, machine.getItem(VendingMachine.C_CODE));
	}
	
	/**
	 * Tests that item slot D can be retrieved
	 */
	@Test
	public void testGetSlotIndexD() throws VendingMachineException {
		assertEquals(null, machine.getItem(VendingMachine.D_CODE));
	}
	
	/**
	 * Tests that adding an item to an empty slot is successful
	 * 
	 */
	@Test
	public void testAddItemToEmptySlot() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.addItem(item2, VendingMachine.B_CODE);
		assertEquals(item1, machine.getItem(VendingMachine.A_CODE));
		assertEquals(item2, machine.getItem(VendingMachine.B_CODE));		
	}
	
	/**
	 * Tests that adding an item to an occupied slot throws exception
	 * 
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItemToFullSlot() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.addItem(item2, VendingMachine.A_CODE);
	}
	
	/**
	 * Tests that adding an item to an invalid code slot throws exception
	 * 
	 */
	@Test(expected = VendingMachineException.class)
	public void testAddItemToInvalidSlot() throws VendingMachineException{
		machine.addItem(item1, "Invalid");
	}
	
	/**
	 * Tests that removing an item from a valid full slot returns correct item
	 * 
	 */
	@Test
	public void testRemovedItemCorrect() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		VendingMachineItem removedItem = machine.removeItem(VendingMachine.A_CODE);
		assertEquals(item1, removedItem);
	}
	
	/**
	 * Tests that removing an item from a valid full slot empties the slot
	 * 
	 */
	@Test
	public void testRemovingItemEmptiesSlot() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.removeItem(VendingMachine.A_CODE);
		assertEquals(null, machine.getItem(VendingMachine.A_CODE));
	}
	
	/**
	 * Tests that removing an item from an empty slot throws exception
	 * 
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemovingEmptyErrors() throws VendingMachineException{
		machine.removeItem(VendingMachine.A_CODE);
	}
	
	/**
	 * Tests that removing from an invalid code slot throws exception
	 * 
	 */
	@Test(expected = VendingMachineException.class)
	public void testRemovingInvalidErrors() throws VendingMachineException{
		machine.removeItem("Invalid");
	}
	
	/**
	 * Tests that inserting a valid amount of money increases balance
	 * 
	 */
	@Test
	public void testInsertMoneySuccess() throws VendingMachineException {
		machine.insertMoney(6.00);
		assertEquals(6.00, machine.balance, 0.001);
		machine.insertMoney(4.00);
		assertEquals(10.00, machine.balance, 0.001);
	}
	
	/**
	 * Tests that inserting an invalid amount of money throws exception
	 * 
	 */
	@Test(expected = VendingMachineException.class)
	public void testInsertInvalidMoneyErrors() throws VendingMachineException {
		machine.insertMoney(-2.00);
	}
	
	/**
	 * Tests that the balance returned is a valid amount, gte 0
	 * 
	 */
	@Test
	public void testGetBalance(){
		assertTrue(machine.getBalance()>=0);
	}
	
	/**
	 * Tests that makePurchase with valid parameters removes Item
	 * 
	 */
	@Test
	public void testMakePurchaseRemovesItem() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.insertMoney(10.0);
		machine.makePurchase(VendingMachine.A_CODE);
		assertEquals(null, machine.getItem(VendingMachine.A_CODE));
	}
	
	/**
	 * Tests that makePurchase with valid parameters decreases balance
	 * 
	 */
	@Test
	public void testMakePurchaseDecreasesBalance() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.insertMoney(10.00);
		machine.makePurchase(VendingMachine.A_CODE);
		assertEquals(5.0, machine.balance, 0.001);
	}
	
	/**
	 * Tests that makePurchase with valid parameters returns true
	 * 
	 */
	@Test
	public void testMakePurchaseReturnsTrue() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.insertMoney(10.0);
		assertTrue(machine.makePurchase(VendingMachine.A_CODE));
	}
	
	/**
	 * Tests that makePurchase with insufficient balance returns false
	 * 
	 */
	@Test
	public void testMakePurchaseLowBalanceFalse() throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.insertMoney(4.0);
		assertFalse(machine.makePurchase(VendingMachine.A_CODE));
	}
	
	/**
	 * Tests that makePurchase returns false when provided an empty slot
	 * 
	 */
	@Test
	public void testMakePurchaseOnEmptyFalse() throws VendingMachineException{
		machine.insertMoney(10.0);
		assertFalse(machine.makePurchase(VendingMachine.A_CODE));
	}
	
	/**
	 * Tests that makePurchase throws exception when provided an invalid code
	 * 
	 */
	@Test(expected = VendingMachineException.class)
	public void testMakePurchasesInvalidCodeErrors()  throws VendingMachineException{
		machine.addItem(item1, VendingMachine.A_CODE);
		machine.insertMoney(10.);
		machine.makePurchase("Invalid");
	}
	
	/**
	 * Tests that returnChange returns the correct amount of change
	 * 
	 */
	@Test
	public void testReturnChangeCorrectAmount(){
		machine.insertMoney(10.0);
		assertEquals(10.0, machine.returnChange(), 0.001);
	}
	
	/**
	 * Tests that returnChange zeroes out the machine balance
	 * 
	 */
	@Test
	public void testReturnChangeZeroesBalance(){
		machine.insertMoney(10.0);
		machine.returnChange();
		assertEquals(0.0, machine.balance, 0.001);
	}
	
}
