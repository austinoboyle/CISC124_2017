package assignment1;

/*
 * A simple class that tests the methods in Assignment1StudentCode.
 * Provided for Assignment 1, CISC 124, Winter 2017
 * Queen's University, M. Kunz
 */


import java.util.*;

public class Assignment1Test {

    /**
     * @param args no command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // asked for input
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("1 inverseArray");
        System.out.println("2 arrayToString");
        System.out.println("3 mergeWithoutDuplicates");
        System.out.println("4 calculateGCD");
        System.out.println("5 rotateLeft");
        
        System.out.print("Enter number of method you would like to test: ");
        
        int number = s.nextInt();
        
        switch(number)
                {
            case 1: 
                    System.out.println("Testing inverseArray()");
                    testing_inverseArray();
                    break;
            case 2:
                    System.out.println("Testing arrayToString()");
                    testing_arrayToString();
                    break;
            case 3:
                    System.out.println("Testing mergeWithoutDuplicates()");
                    testing_mergeWithoutDuplicates();
                    break;
            case 4:
                    System.out.println("Testing calculateGCD()");
                    testing_findGCD();
                    break;
            case 5:
                    System.out.println("Testing rotateLeft()");
                    testing_rotateLeft();
                    break;
            default:
                    System.out.println("No valid input."); 
        }   
        
            
        
    }
    
    // helper function to print array
    static void printArray(int[] a) {
        
        System.out.print("[");
        for (int i=0; i<a.length-1; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println(a[a.length-1]+"]");
    }
    
    // test for inverseArray method
    // the method asked for user input of an array
    // as print this array after the inverse method was called
    
    static void testing_inverseArray() {
        // asked user input for a list
        int[] a = inputList();
        System.out.print("Before inverse: ");
        printArray(a);
        
        Assignment1StudentCode.inverseArray(a);
        System.out.print("After inverse: ");
        printArray(a); 
        
    }
    
    // test for the method mergeWithoutDuplicates
    // the method generated two small sorted lists (with duplicates) and prints
    // the length as well as the elements of the merged list
    
    static void testing_mergeWithoutDuplicates() {
        int[] myList1 = {1,2,3,4,5};
        int[] myList2 = {2,3,6};

        System.out.println("List 1: [1, 2, 3, 4, 5], List 2: [2, 3, 6]");
        
        // call the merge function
        int[] lmerged_lst = Assignment1StudentCode.mergeWithoutDuplicates(myList1, myList2);
        System.out.println("The length of the merged list is " + lmerged_lst.length);
        
        if (lmerged_lst.length != 0) {
            // print elements of merged list
            System.out.print("The merged list is: [");
            for (int i = 0; i < lmerged_lst.length-1; i++){
                System.out.print(lmerged_lst[i]+", ");
            }
            System.out.println(lmerged_lst[lmerged_lst.length-1]+"]");
        }

    }
    
    // test for the arrayToString method
    // the method asked for user input: a list, a char (Separator), and a int (spaces)
    // the resulting string is printed
    
    static void testing_arrayToString(){
        
        // asked user input for a list
        int[] array1 = inputList();
        
        // user input for separator character
        Scanner s = new Scanner(System.in);
        String str;
        do {
            System.out.print("Enter the separation character: ");
            str = s.next();
            // check validity of input
            if (str.length() != 1)
                System.out.println("Enter one character.");
        } while(str.length() != 1); // repeat until valud input
             
        // convert string to char
        char[] chList = str.toCharArray();
        
        // user input for number of spaces
        int nrSpaces = -1;
        do {
            System.out.print("Enter the number of spaces between elements: ");
            if (s.hasNextInt())
                nrSpaces = s.nextInt();
            if (nrSpaces < 0)
                System.out.println("Enter a positive integer number.");
        } while(nrSpaces < 0);  // loop until valid input
        
        // call arrayToString method
        String resultStr = Assignment1StudentCode.arrayToString(array1, chList[0], nrSpaces);
     
        // output result string
        System.out.println("The result string is: \""+resultStr+"\"");
        
    }
    
    // testing for the calculateGCD method
    // the method asked the user to input an array and validates that all elements
    // are non-negative.
    // the caluclated greatest common divisor is printed
    
    static void testing_findGCD(){
        
        int[] lst;
        boolean check;
        // user input list
        do {
            lst = inputList();
            check = true;
            for (int i=0; i < lst.length; i++)
                if (lst[i] < 0)
                    check = false;
            if (!check)
                System.out.println("Enter only non-negative elements.");
        } while (!check);  // until input is valid
        
        // call assignment method
        int result = Assignment1StudentCode.calculateGCD(lst);
        // print result
        System.out.println("The greatest common devisor is: " + result);
    }
    
    // helper method for user input of an array
    static int[] inputList(){
        Scanner s = new Scanner(System.in);
        int nrElements = 0;
        System.out.print("Enter number of elements in array: ");
        nrElements = s.nextInt();
        
        int[] array1 = new int[nrElements];
        
        System.out.print("Enter "+nrElements+" integer numbers (separated by space): ");
        for (int i=0; i < nrElements; i++){
            array1[i] = s.nextInt(); 
        }
        
        return array1;
    }
    
    // testing for the rotateLeft method
    // the method generates a 10 x 5 matrix and prints the 
    // rotated matrix
    
    static void testing_rotateLeft(){
        // create a 2d array and fill with values 
        // original array is printed
        int[][] a = new int[10][5];
        System.out.println("The original array:");
        for (int i=0; i< 10; i++){
            for (int j=0; j<5; j++) {
                a[i][j] = (i+1)*j;
                System.out.printf("%3d ", a[i][j]);
            }
            System.out.print("\n");
        }   
        
        // call assignment method
        System.out.println("After rotation: ");
        int[][] result = Assignment1StudentCode.rotateLeft(a);
        
        // print rotated matrix
        for (int i=0; i< result.length; i++){
            for (int j=0; j<result[0].length; j++) {
                System.out.printf("%3d ", result[i][j]);
            }
            System.out.print("\n");
        }
        
    } 
    
    
}
