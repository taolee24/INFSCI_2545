package hw2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.junit.Assert.*;

public class CitySim9002Test {

    @Mock
    Visitor mockedVisitor = Mockito.mock(Visitor.class);
    CitySim9002 mockedCitySim = Mockito.mock(CitySim9002.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(mockedVisitor);
        MockitoAnnotations.initMocks(mockedCitySim);
    }

    @After
    public void tearDown() throws Exception {
    }

   

    //Test checkInput function
    //Test if it will return True when we input a valid integer 1  
    @Test
    public void testCheckInput1() {
        String a = "1";
        CitySim9002 input = new CitySim9002();
        assertTrue(input.checkInput(a));
    }

    //Test if it will return false when we input a sting k
    @Test
    public void testCheckInput2() {
        String a = "k";
        CitySim9002 input = new CitySim9002();
        assertFalse(input.checkInput(a));
    }
    //Test if it will return false when we input two integer 
    @Test
    public void testCheckInput3() {
        String a = "2 4";
        CitySim9002 input = new CitySim9002();
        assertFalse(input.checkInput(a));
    }
   
    //Test that if a visitor(Business Person) did not like the place and left, it will return false
    @Test
    public void testplacelike1() {
        CitySim9002 Placelike = new CitySim9002();
        Visitor a = new Visitor();
        a.setType("Business Person");
        assertFalse(Placelike.placelike(a, "The Point"));
    }

    //Test that if a visitor(Student)like the place, it will return true
    @Test
    public void testplacelike2() {
        CitySim9002 Placelike = new CitySim9002();
        Visitor a = new Visitor();
        a.setType("Student");
        assertTrue(Placelike.placelike(a, "Downtown"));
    }


    //Test that it will return false when a Blogger who dislike all locations visit places
    @Test
    public void testplacelike3() {
        CitySim9002 Placelike = new CitySim9002();
        Visitor a = new Visitor();
        a.setType("Blogger");
        assertFalse(Placelike.placelike(a, "The Point"));
    }
}
 