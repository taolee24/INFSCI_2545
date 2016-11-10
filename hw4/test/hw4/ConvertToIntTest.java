package hw4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConvertToIntTest {

   // test value 0
    @Test
    public void TestConvertToIntZero() { 
        try {
            MainPanel m = new MainPanel(15);
            int n = m.convertToInt(0);
            assertEquals(0, n);
        }catch (Exception e) {
            fail();
        }
    }
    
    //test correct value
 @Test
    public void testConvertToIntCorrect() { 
        try {
            MainPanel m = new MainPanel(15);
            int n = m.convertToInt(10);
            assertEquals(10, n);
        }catch (Exception e) {
            fail();
        }
    }
    
   // test max value
    @Test
    public void TestConvertToIntMax() { 
        try {
            MainPanel m = new MainPanel(15);
            int n = m.convertToInt(Integer.MAX_VALUE);
            assertEquals(Integer.MAX_VALUE, n);
        }catch (Exception e) {
            fail();
        }
    }

   

  
}