package extraProjectsWeek2;

public class LoanPayments {
    
    
    public static void calculateMonthlyPayment(final int loanAmount, final int loanPeriod, final int compoundingRate, final int interestRatePercentage){
        double currentBalance = loanAmount;
        double rate = 1 + 0.01 * interestRatePercentage;
        final int numPeriods = loanPeriod * compoundingRate;
        double ratePerPeriod = rate/(numPeriods);
        double monthlyPayment = ratePerPeriod * currentBalance/(1- Math.pow(1 + ratePerPeriod ,  -numPeriods));
        double totalPayment = numPeriods * monthlyPayment;
        
        System.out.println(monthlyPayment);
        System.out.println(totalPayment);
    }
    
    public static void main (String[] args){
        
    }
}
