package hw4;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class ConvertIntTest {
	
	private static Method convertToInt;			// Reflected private method
	private static MainPanel panel;
	
	
	/**
	 * Uses reflection to set up and test the private slowlife.MainPanel.convertToInt() method
	 * @throws Exception
	 */
	@BeforeClass
	public static void NewMethods() throws Exception {
			convertToInt = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
			convertToInt.setAccessible(true);
	}

	@Before
	public void NewMP() {
		
		panel = new MainPanel(15);
	}
	
	
	/**
	 * Test a random integer 10
	 */
	@Test
	public void test10() throws InvocationTargetException, IllegalAccessException {
		
		Object Obj;
		int Int;

			Obj = convertToInt.invoke(panel, 10);
			Int = (Integer) Obj;
			assertEquals(Int, 10);

	}
	
	
	/**
	 * Tests the maximum int
	 */
	@Test
	public void testMaxValue() throws InvocationTargetException, IllegalAccessException {
		
		Object Obj;
		int Int;

			Obj = convertToInt.invoke(panel, Integer.MAX_VALUE);
			Int = (Integer) Obj;
			assertEquals(Int, Integer.MAX_VALUE);
	}
	
	
	/**
	 * Tests zero
	 */
	@Test
	public void test0() throws InvocationTargetException, IllegalAccessException {
		
		Object Obj;
		int Int;
		
			Obj = convertToInt.invoke(panel, 0);
			Int = (Integer) Obj;
			assertEquals(Int, 0);
	}
}