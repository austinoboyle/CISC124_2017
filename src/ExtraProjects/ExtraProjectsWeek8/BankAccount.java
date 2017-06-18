package ExtraProjects.ExtraProjectsWeek8;

import java.util.*;

public class BankAccount {
    private String customerId;
    private int accountNumber;
    private int balance;
    
    Scanner input = new Scanner(System.in);
    
    public BankAccount() {
        getCustomerId();
        getAccountNumber();
        getBalance();
    }
    
    public void getCustomerId(){
        boolean valid = false;
        String ID = "";
        while (!valid){
            try{
                System.out.print("Enter your customer ID: ");
                ID = input.nextLine();
                System.out.println("");
                valid = isValidID(ID);
                if (!valid)
                    throw new Exception("Invalid Customer ID");
            }
            
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        
        this.customerId = ID;
    } 
    
    private boolean isValidID(String ID){
        if (ID.length() != 4){
            return false;
        }
        if (!Character.isAlphabetic(ID.charAt(0))){
            return false;
        }
        for (int i = 1; i<4; i++){
            if (!Character.isDigit(ID.charAt(i)))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        
    }

}
