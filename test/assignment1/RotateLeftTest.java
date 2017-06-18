package assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateLeftTest {

    @Test
    public void testEmptyMatrix() {
        int[][] matrix = {};
        int[][] correctRotatedMatrix = {};
        int[][] rotatedMatrix = Assignment1StudentCode.rotateLeft(matrix);
        
        assertEquals("Expected 0 rows", correctRotatedMatrix.length, rotatedMatrix.length);
        
    }
    
    @Test
    public void test1RowNowColumns() {
        int[][] matrix = {{}};
        int[][] correctRotatedMatrix = {};
        int[][] rotatedMatrix = Assignment1StudentCode.rotateLeft(matrix);
        assertEquals("Expected different", correctRotatedMatrix.length, rotatedMatrix.length);
    }
    
    @Test
    public void test1By1() {
        int[][] matrix = {{1}};
        int[][] correctRotatedMatrix = {{1}};
        int[][] rotatedMatrix = Assignment1StudentCode.rotateLeft(matrix);
        
        assertEquals("Expected different number of rows", rotatedMatrix.length, correctRotatedMatrix.length);
        assertEquals("Expected different number of columns", rotatedMatrix[0].length, correctRotatedMatrix[0].length);
        
        for (int i = 0; i < correctRotatedMatrix.length; i++){
            for (int j = 0; j < correctRotatedMatrix[0].length; j++){
                assertEquals("Expected different elements in rotated matrix", rotatedMatrix[i][j], correctRotatedMatrix[i][j]);
            }
        }        
    }
    
    @Test
    public void test3x3() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] correctRotatedMatrix = {{3,6,9},{2,5,8},{1,4,7}};
        int[][] rotatedMatrix = Assignment1StudentCode.rotateLeft(matrix);
        
        assertEquals("Expected different number of rows", rotatedMatrix.length, correctRotatedMatrix.length);
        assertEquals("Expected different number of columns", rotatedMatrix[0].length, correctRotatedMatrix[0].length);
        
        for (int i = 0; i < correctRotatedMatrix.length; i++){
            for (int j = 0; j < correctRotatedMatrix[0].length; j++){
                assertEquals("Expected different elements in rotated matrix", rotatedMatrix[i][j], correctRotatedMatrix[i][j]);
            }
        }        
    }
    
    @Test
    public void testTallRect() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] correctRotatedMatrix = {{3,6,9,12},{2,5,8,11},{1,4,7,10}};
        int[][] rotatedMatrix = Assignment1StudentCode.rotateLeft(matrix);
        
        assertEquals("Expected different number of rows", rotatedMatrix.length, correctRotatedMatrix.length);
        assertEquals("Expected different number of columns", rotatedMatrix[0].length, correctRotatedMatrix[0].length);
        
        for (int i = 0; i < correctRotatedMatrix.length; i++){
            for (int j = 0; j < correctRotatedMatrix[0].length; j++){
                assertEquals("Expected different elements in rotated matrix", rotatedMatrix[i][j], correctRotatedMatrix[i][j]);
            }
        }        
    }
    
    @Test
    public void testWideRect() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] correctRotatedMatrix = {{4,8,12},{3,7,11},{2,6,10},{1,5,9}};
        int[][] rotatedMatrix = Assignment1StudentCode.rotateLeft(matrix);
        
        assertEquals("Expected different number of rows", rotatedMatrix.length, correctRotatedMatrix.length);
        assertEquals("Expected different number of columns", rotatedMatrix[0].length, correctRotatedMatrix[0].length);
        
        for (int i = 0; i < correctRotatedMatrix.length; i++){
            for (int j = 0; j < correctRotatedMatrix[0].length; j++){
                assertEquals("Expected different elements in rotated matrix", rotatedMatrix[i][j], correctRotatedMatrix[i][j]);
            }
        }        
    }

}
