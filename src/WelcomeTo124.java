/**
 * @author Austin O'Boyle
 * I hereby declare that Austin O'Boyle wrote this code
 */

import java.util.*;
public class WelcomeTo124 {

    
    public static boolean isValidPassword(String password){
        if (password.length() < 8)
            return false;
        
        int numDigits = 0;
        int numCaps = 0;
        for (char c: password.toCharArray()){
            if (Character.isDigit(c))
                numDigits++;
            else if (Character.isAlphabetic(c) && c==Character.toUpperCase(c))
                numCaps++;
        }
        
        return numDigits > 1 && numCaps > 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sortCharacters("HEllo"));
		int a = 0;
		double b = 0.1;
		System.out.println(a==b);
		System.out.println(new ArrayList<String>() instanceof Collection);
	}
	
	public static String sortCharacters(String word){
	    char[] wordArray = word.toCharArray();
	    String newString = "";
	    int length = word.length();
	    char smallestChar;
	    int smallestCharLocation;
	    for(int i = 0; i < length; i++){
	        smallestChar = 1000; 
	        smallestCharLocation = 0;
	        for (int j = i; j < length; j++){
	            if (Character.toLowerCase(wordArray[j]) < smallestChar){
	                smallestChar = Character.toLowerCase(wordArray[j]);
	                smallestCharLocation = j;
	            }       
	        }
	        
	        char smallest = wordArray[smallestCharLocation];
	        wordArray[smallestCharLocation] = wordArray[i];
	        wordArray[i] = smallest;
	        
	        newString += smallest;
	                
	    }
	    return newString;
	    
	}

}

