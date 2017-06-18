package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateGcdTest {

    @Test
    public void testOneElement() {
        int[] array = {3};
        int correctGcd = 3;
        int gcd = Assignment1StudentCode.calculateGCD(array);
        
        assertEquals("Expected a different calculated gcd", gcd, correctGcd);
    }
    
    @Test
    public void testGcdOfOne() {
        int[] array = {5, 10, 11};
        int correctGcd = 1;
        int gcd = Assignment1StudentCode.calculateGCD(array);
        
        assertEquals("Expected a different calculated gcd", gcd, correctGcd);
    }
    
    @Test
    public void testAllMultiples() {
        int[] array = {5, 10, 15, 20, 25};
        int correctGcd = 5;
        int gcd = Assignment1StudentCode.calculateGCD(array);
        
        assertEquals("Expected a different calculated gcd", gcd, correctGcd);
    }
    
    @Test
    public void testSomeMultiples() {
        int[] array = {6, 9, 18, 33, 36};
        int correctGcd = 3;
        int gcd = Assignment1StudentCode.calculateGCD(array);
        
        assertEquals("Expected a different calculated gcd", gcd, correctGcd);
    }

}
