package welcomeTo124;

/**
 * @author Austin O'Boyle
 * I hereby declare that Austin O'Boyle wrote this code
 */

public class WelcomeTo124 {

	/**
	 * @param args
	 */
    public static void main(String[] args){
    
        boolean[] bArray = new boolean[5];
	
        for (int i = 0; i<5; i++){
            bArray[i] = true;
        }
	    
        bArray = new boolean[10];
        System.out.println(bArray[0] + " " + bArray[9]);

	}

}
