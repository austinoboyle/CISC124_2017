package extraProjectsWeek4;

public class Fraction {
    private int numerator;
    private int denominator;
    
    public void setNumerator(int newNumerator){
        this.numerator = newNumerator;
    }
    public void setDenominator(int newDenominator){
        this.denominator = newDenominator;
    }
    public void getReducedFraction(){
        int gcd = gcd(this.numerator, this.denominator);
        int reducedNumerator = this.numerator/gcd;
        int reducedDenominator = this.denominator/gcd;
        System.out.println(reducedNumerator + "/" + reducedDenominator);
    }
    
    private static int gcd(int numerator, int denominator){
        int minValue = Math.min(numerator, denominator);
        int gcd = 1;
        for (int i = minValue; i > 0; i--){
            if (numerator % i == 0 && denominator % i == 0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }
    public static void main(String[] args){
        Fraction fraction = new Fraction();
        fraction.setNumerator(4);
        fraction.setDenominator(14);
        fraction.getReducedFraction(); 
        fraction.setDenominator(18);
        fraction.getReducedFraction();
    }
}
