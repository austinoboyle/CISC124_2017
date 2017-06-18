package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class InverseArrayTest {

    @Test
    public void testNoElements() {
        int[] array = {};
        Assignment1StudentCode.inverseArray(array);
        assertTrue("Expected empty list", array.length == 0);
    }
    
    @Test
    public void testOddElements() {
        int[] array = {1,2,3};
        int[] reversedArray = {3,2,1};
        Assignment1StudentCode.inverseArray(array);
        
        for (int i = 0; i < array.length; i++){
            assertEquals("Expected array to be reversed", array[i], reversedArray[i]);
        }
        assertEquals("Expected returned array of same size", array.length, reversedArray.length);

    }

    
    @Test
    public void testEvenElements() {
        int[] array = {1,2,3,4};
        int[] reversedArray = {4,3,2,1};
        Assignment1StudentCode.inverseArray(array);
        
        for (int i = 0; i < array.length; i++){
            assertEquals("Expected array to be reversed", array[i], reversedArray[i]);
        }
        assertEquals("Expected returned array of same size", array.length, reversedArray.length);
    }

}
