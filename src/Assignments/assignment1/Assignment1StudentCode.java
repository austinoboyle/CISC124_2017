package assignment1;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Austin O'Boyle
 * Austin O'Boyle declares that he indeed has written this code 
 * This class contains the method stubs for assignment 1, CISC 124 Winter 2017
 */

public class Assignment1StudentCode {
    
/**
 * This method takes a list of integers and mutates the array such that the order
 * of the integers is reversed
 * 
 * @param lst
 *          list of integers
 * @return void
 * MUTATES LIST
 */
    
    public static void inverseArray(int[] lst)
    {
        int lenList = lst.length;
        //each iteration swaps two outer elements of list, and then moves to the next two inner elements
        
        for (int i = 0; i < lenList/2; i++){
            int temp = lst[i];
            lst[i] = lst[lenList-i-1];
            lst[lenList-i-1] = temp;
        }
    }
    
/**
 *     This method takes a list of integers, a separator character, and a number of spaces.
 *     It returns a string with the integers separated by the separator character, and a defined
 *     number of spaces on each side of the separator
 *     
 * @param arr
 *      array of integers
 * @param separator
 *      any single character
 * @param spaces
 *      integer, number of spaces to put between integers and the separator character
 * @return
 *      String as defined in description
 */     
    
    public static String arrayToString(int[] arr, char separator, int spaces){
        
        String outputString = "";
        final int arrLength = arr.length;
        
        //used to create the string between each pair of integers
        final String emptySpaces = new String(new char[spaces]).replace("\0", " ");
        final String betweenIntString = emptySpaces + separator + emptySpaces;
        
        //Each iteration adds the string equivalent of the integer to the output string, 
        //and the between integer character if it is not the last int in the array
        for (int i = 0; i < arrLength; i++){
            //last element in array
            if (i < arrLength - 1)
                outputString += Integer.toString(arr[i]) + betweenIntString; 
            
            else
                outputString += Integer.toString(arr[i]);    
        }
        return outputString; // returns a empty string (stub), needs to be replaced with your code
    }
    
    /**
     * This method merges two sorted lists together returning a new 
     * ordered list with no duplicate elements.
     * 
     * @param list1
     *          sorted list of integers, may be empty
     * @param list2
     *          sorted list of integers, may be empty
     * @return
     *          sorted, merged list of integers with no repeated values
     */
    
    public static int[] mergeWithoutDuplicates(int[] list1, int[] list2){
        //Use TreeSet - An Ordered Set.  Sets do not have duplicate elements
        Set<Integer> newSet = new TreeSet<Integer>();
        
        int len1 = list1.length; //define lengths of each original list
        int len2 = list2.length;
        int i, j; //counters for index of list 1 and 2 respectively
        
        for (i = 0, j = 0; i < len1 && j < len2; ){
            
            //checks which element is lower and appends, incrementing index of list used
            
            if (list1[i] <= list2[j]){
                newSet.add(list1[i]);
                i++;
            }else{
                newSet.add(list2[j]);
                j++;
            }  
        }
        
        //When loop finishes, one list may have some unused elements
        if (i < len1)    
            for (int k = i; k < len1; k++)
                newSet.add(list1[k]);       
        
        else if (j < len2)
            for (int k = j; k < len2; k++)
                newSet.add(list2[k]);
           
        //create return array of correct size
        int[] newArray = new int[newSet.size()];
        int currentIndex = 0;
        
        //add elements of set to return array in order
        for (int k: newSet){
            newArray[currentIndex] = k;
            currentIndex++;
        }
        
        return newArray;
    }
    
    /**
     * Calculates the greatest common divisor of a list of positive integers.  As Per the Hint in the assignment spec
     * it is assumed that the array will not contain a zero.  "GCD will be between 1 and the lowest integer
     * in the list"
     * 
     * @param lst
     *          list of positive integers
     * @return
     *          integer: greatest common divisor of the list of integers in lst
     */
    
    public static int calculateGCD(int[] lst){
        int gcd = 1;
        //find min element in list (maximum possible gcd)
        int maxPossibleGcd = findMin(lst);
        
        //check all possible divisors starting from highest.  Stop at first divisor
        for (int divisor = maxPossibleGcd; divisor > 0; divisor--){
            boolean isDivisor = true;
            
            //check divisibility with each array element
            for (int j : lst){
                if (j % divisor != 0){
                    isDivisor = false;
                    break;
                }
            }
            
            if (isDivisor){
                gcd = divisor;
                break;
            }
        }
        return gcd;
        
    }
    
    
    /**
     * Takes a 2D array as a parameter and returns a new array that is rotated 90 degrees from
     * the passed array in the counterclockwise direction
     * 
     * @param a
     *       2D rectangular array of integers
     * @return
     *       2D rectangular array of integers "rotated" 90 degrees CCW from original
     */
    
    public static int[][] rotateLeft(int[][] a){

        int[][] emptyArray = {};
        if (a.length == 0)
            return emptyArray;
            
        if (a[0].length == 0)
            return emptyArray;
        
        //Find number of rows and columns
        int numRows = a.length;
        int numCols = a[0].length;
        
        //duplicate original array so as to not mutate it
        int[][] copy = new int[numRows][numCols];
        
        for (int row= 0; row < numRows; row++)
            for (int col = 0; col < numCols; col++)
                copy[row][col] = a[row][col];
        
        //this loop reverses the order of each row
        for (int[] row: copy)
            inverseArray(row);
        
        int[][] rotated = new int[numCols][numRows];
        
        //these loops transpose the matrix
        for (int row = 0; row < numRows; row++)
            for (int col = 0; col < numCols; col++)
                rotated[col][row] = copy[row][col];
        
        return rotated;
        }
    
    
    /**
     * 
     * @param lst
     *          non-empty list of non-negative integers
     * @return
     *          minimum integer in the list
     */
    
    private static int findMin(int[] lst){
        int minValue = 2147483647; //Max Integer Value
        for (int i: lst)
            if (i < minValue)
                minValue = i;   
        return minValue;   
    }
    
    
}
