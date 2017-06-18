package extraProjectsWeek4;

public class BeerSong {
    private int numberOfBottles;
    
    public BeerSong (int numberOfBottles){
        if (numberOfBottles < 0)
            numberOfBottles = 0;
        else if (numberOfBottles > 99)
            numberOfBottles = 99;
        this.numberOfBottles = numberOfBottles;
    }
    
    public void printSong(){
        String numberString = numberToString(this.numberOfBottles);
        while (this.numberOfBottles > 0){
            System.out.println(numberString + " Bottles of beer on the wall,");
            System.out.println(numberString + " Bottles of beer,");
            System.out.println("Take one down, pass it around,");
            this.numberOfBottles--;
            numberString = numberToString(this.numberOfBottles);
            System.out.println(numberString + " Bottles of beer on the wall.\n");
        }
    }
    private static String numberToString(int number) {
        
        final String[] underTwentyList= {
                "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
                "Eighteen", "Nineteen"
        };
        
        final String[] tens = {
                "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        
        if (number < 20)
            return underTwentyList[number];
        else if (number % 10 == 0)
            return tens[number / 10 - 2];
        else
            return (tens[number / 10 - 2]) + "-" + underTwentyList[number % 10];
    }
    
    public static void main(String[] args){
        BeerSong beersong = new BeerSong(35);
        beersong.printSong();
    }
}
