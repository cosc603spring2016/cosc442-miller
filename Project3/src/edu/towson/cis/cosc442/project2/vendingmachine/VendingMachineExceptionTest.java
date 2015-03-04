package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.Test;

public class VendingMachineExceptionTest {

	@Test(expected = VendingMachineException.class)
	public void testDefaultConstructor() throws VendingMachineException{
		throw new VendingMachineException();
	}
	
	@Test(expected = VendingMachineException.class)
	public void testStringConstructor() throws VendingMachineException{
		throw new VendingMachineException("A Reason");
	}
	

}
