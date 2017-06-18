package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayToStringTest {

    @Test
    public void testEmptyArray() {
        int[] array = {};
        String correctString = "";
        String testString = Assignment1StudentCode.arrayToString(array, '-', 4);
        
        assertTrue ("Expected empty string returned", testString.equals(correctString));
    }
    
    @Test
    public void testSingleElement() {
        int[] array = {1};
        String correctString = "1";
        String testString = Assignment1StudentCode.arrayToString(array, '-', 4);
        assertTrue ("Expected returned string to be '1'.", testString.equals(correctString));
    }
    
    @Test
    public void testNoSpaces() {
        int[] array = {1,2,3,4,5};
        String correctString = "1-2-3-4-5";
        String testString = Assignment1StudentCode.arrayToString(array, '-', 0);
        
        assertTrue ("Expected returned string to be '1-2-3-4-5'.", testString.equals(correctString));
    }
    
    @Test
    public void testMultipleSpaces() {
        int[] array = {1,2,3};
        String correctString = "1   -   2   -   3";
        String testString = Assignment1StudentCode.arrayToString(array, '-', 3);
        
        assertTrue ("Expected return string '1   -   2   -   3'.", testString.equals(correctString));
    }

}
