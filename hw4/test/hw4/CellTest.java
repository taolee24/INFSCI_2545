package hw4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CellTest 
{
	// make sure that the method returns the value with alive cell
	@Test
	public void CellTestLive() 
	{
		Cell c= new Cell();
		c.setAlive(true);
		assertTrue(c.toString().equals("X"));
	}
	
	// make sure that the method returns the value with dead cell
	@Test
	public void CellTestDead() 
	{
		Cell c = new Cell();
		c.setAlive(false);
		assertTrue(c.toString().equals("."));
	}
	
	// make ensure that the method "toString" returns the cell is dead now,
	@Test
	public void CellTest() 
	{
		Cell c = new Cell();
		c.setAlive(true);
		c.setAlive(false);
		assertTrue(c.toString().equals("."));
	}

}