package extraProjectsWeek4;

public class PrintCodeword {
    private char startLetter;
    private final int startNumber;
    
    public PrintCodeword(char startLetter, final int startNumber){
        this.startLetter = Character.toUpperCase(startLetter);
        this.startNumber = startNumber;
    }
    
    public void printCode(){
        char currentLetter = this.startLetter;
        int currentLetterInt = (int) currentLetter;
        for (int i = 0; i < 26; i++){
            currentLetter = (char) (65 + ((currentLetterInt + i - 65) % 26));
            System.out.println(currentLetter + Integer.toString((this.startNumber + i) % 10));
        }

    }
    
    public static void main(String args[]){
        PrintCodeword codeword = new PrintCodeword('D', 5);
        codeword.printCode();  
    }
}
