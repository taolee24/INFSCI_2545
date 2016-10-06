package hw2;
import org.junit.Assert;
import org.junit.Test;


public class VisitorTest {

    //Test that each visitor will get the number we set 
    @Test
    public void testGetNum1() {
        Visitor v = new Visitor();
        v.setNum(1);
        Assert.assertEquals(1, v.getNum());
    }
//Test that system will return the type of each visitor we set 
    @Test
    public void testGetType1() {
        Visitor v = new Visitor();
        v.setType("Student");
        Assert.assertEquals("Student", v.getType());
    }
    
    @Test
    public void testGetType2() {
        Visitor v = new Visitor();
        v.setType("Professor");
        Assert.assertEquals("Professor", v.getType());
    }
    @Test
    public void testGetType3() {
        Visitor v = new Visitor();
        v.setType("Business Person");
        Assert.assertEquals("Business Person", v.getType());
    }
    @Test
    public void testGetType4() {
        Visitor v = new Visitor();
        v.setType("Blogger");
        Assert.assertEquals("Blogger", v.getType());
    }
}