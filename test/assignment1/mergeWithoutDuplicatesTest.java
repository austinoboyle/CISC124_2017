package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class mergeWithoutDuplicatesTest {

    @Test
    public void testBothEmpty() {
        int[] array1 = {};
        int[] array2 = {};
        int[] mergedArray = Assignment1StudentCode.mergeWithoutDuplicates(array1, array2);
        
        assertTrue("Expected empty array returned", mergedArray.length == 0);
       
    }

    @Test
    public void testOneEmpty() {
        int[] array1 = {};
        int[] array2 = {1,2,3};
        int[] correctArray = {1,2,3};
        int[] mergedArray = Assignment1StudentCode.mergeWithoutDuplicates(array1, array2);
        
        assertEquals("Expected merged array of length 3", mergedArray.length, 3);
        for (int i = 0; i < correctArray.length; i++){
            assertEquals("Expected merged array to be the same as non-empty array",mergedArray[i], correctArray[i]);
        }
    }
    
    @Test
    public void testAllUnique() {
        int[] array1 = {1,2,4};
        int[] array2 = {3,5,6};
        int[] correctArray = {1,2,3,4,5,6};
        int[] mergedArray = Assignment1StudentCode.mergeWithoutDuplicates(array1, array2);
        
        assertEquals("Expected merged array length equal to number of unique elements", mergedArray.length, correctArray.length);
        for (int i = 0; i < correctArray.length; i++){
            assertEquals("Expected merged array to be the same as correct array",mergedArray[i], correctArray[i]);
        }
    }
    
    @Test
    public void testSomeUnique() {
        int[] array1 = {1,2,3};
        int[] array2 = {3,4,5};
        int[] correctArray = {1,2,3,4,5};
        int[] mergedArray = Assignment1StudentCode.mergeWithoutDuplicates(array1, array2);
        
        assertEquals("Expected merged array length equal to number of unique elements", mergedArray.length, correctArray.length);
        for (int i = 0; i < correctArray.length; i++){
            assertEquals("Expected merged array to be the same as correct array",mergedArray[i], correctArray[i]);
        }
    }
    
    @Test
    public void testTotalDuplicate() {
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        int[] correctArray = {1,2,3};
        int[] mergedArray = Assignment1StudentCode.mergeWithoutDuplicates(array1, array2);
        
        assertEquals("Expected merged array length equal to number of unique elements", mergedArray.length, correctArray.length);
        for (int i = 0; i < correctArray.length; i++){
            assertEquals("Expected merged array to be the same as correct array",mergedArray[i], correctArray[i]);
        }
    }
}
