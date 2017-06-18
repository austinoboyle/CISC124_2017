package ExtraProjects.ExtraProjectsWeek8;

import java.util.*;

public class CalculateAverageValue {

    private ArrayList<Integer> listOfValues;
    private double averageValue;
    
    public CalculateAverageValue() {
        listOfValues = new ArrayList<Integer>();
        setAllValues();
        setAverageValue();
    }
    
    public void setAverageValue(){
        double sum = 0;
        for (int i: this.listOfValues){
            sum += i;
        }
        this.averageValue = sum/this.listOfValues.size();
    }
    
    public double getAverageValue(){
        return this.averageValue;
    }
    
    public void setAllValues(){
        int numInts = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of integers you want to find the average of");
        //this.listOfValues.clear();
        
        boolean validNumber = false;
        
        while (!validNumber){
            try{
                numInts = Integer.parseInt(input.next());
                if (numInts < 0){
                    throw new Exception("");
                }
                validNumber = true;                  
            }
            catch (Exception e){
                System.err.println("Need a valid positive integer");
            }
        }
        
        int currentInt = 1;
        
        while (currentInt <= numInts){
            int nextInt;
            try{
                System.out.print("Enter integer number " + currentInt + ": ");
                nextInt = input.nextInt();
                this.listOfValues.add(nextInt);
                currentInt++;
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        
        
        
    }
    
    public static void main (String[] args){
        CalculateAverageValue averageValue1 = new CalculateAverageValue();
        System.out.println(averageValue1.getAverageValue());
    }
}
